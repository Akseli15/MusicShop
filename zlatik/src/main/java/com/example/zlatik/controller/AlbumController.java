package com.example.zlatik.controller;

import com.example.zlatik.entity.Album;
import com.example.zlatik.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Time;
import java.time.LocalDate;

@Controller
@RequestMapping("/")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @Async
    @GetMapping("/")
    public String getAllAlbums(Model model) {
        model.addAttribute("albums", albumService.getAllAlbums());
        return "album";
    }
    @Async
    @GetMapping("/{id}")
    public String getAlbumById(@PathVariable("id") String id, Model model) {
        Album album = albumService.getAlbumById(id);
        model.addAttribute("album", album);
        return "album-details";
    }
    @Async
    @PostMapping("/create")
    public String createAlbum(@ModelAttribute Album album){
        albumService.createAlbum(album);
        return "redirect:/";
    }
    @Async
    @PostMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable("id") String id) {
        albumService.deleteAlbum(id);
        return "redirect:/";
    }
    @Async
    @PostMapping("/save")
    public String saveAlbum(@ModelAttribute("album") Album album) {
        albumService.saveAlbum(album);
        return "redirect:/";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getAlbum(@PathVariable("id") String id, Model model) {
        Album album = albumService.getAlbumById(id);
        if (album != null) {
            model.addAttribute("album", album);
        }
        return "editalbum";
    }

    @Async
    @PostMapping("/edit/{id}")
    public String editAlbum(@PathVariable("id") String id,
                            @RequestParam(value = "newId", required = false) String newId,
                            @RequestParam(value = "releaseDate", required = false) String releaseDate,
                            @RequestParam(value = "duration", required = false) String duration) {
        Album album = albumService.getAlbumById(id);
        if (album == null) {
            return "redirect:/edit/" + id + "?error=true";
        }
        if (newId != null) {
            album.setId(newId);
        }
        if (releaseDate != null) {
            album.setReleaseDate(LocalDate.parse(releaseDate));
        }
        if (duration != null) {
            album.setDuration(Time.valueOf(duration));
        }
        albumService.saveAlbum(album);
        return "redirect:/";
    }
}
