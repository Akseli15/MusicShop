package com.example.zlatik.controller;

import com.example.zlatik.entity.Album;
import com.example.zlatik.entity.Song;
import com.example.zlatik.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;
    @Async
    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("albums", albumService.getAll());
        return "album";
    }
    @Async
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Album album = albumService.getById(id);
        model.addAttribute("album", album);
        return "album-details";
    }
    @Async
    @PostMapping("/create")
    public String create(@ModelAttribute Album album){
        albumService.create(album);
        return "redirect:/album";
    }
    @Async
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        albumService.delete(id);
        return "redirect:/album";
    }
    @Async
    @PostMapping("/save")
    public String save(@ModelAttribute("album") Album album) {
        albumService.update(album);
        return "redirect:/album";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getAlbum(@PathVariable("id") Long id, Model model) {
        Album album = albumService.getById(id);
        model.addAttribute("album", album);
        return "editalbum";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editAlbum(@ModelAttribute Album album) {
        albumService.update(album);
        return "redirect:/album";
    }
}
