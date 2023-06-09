package com.example.zlatik.controller;

import com.example.zlatik.entity.Album;
import com.example.zlatik.entity.Artist;
import com.example.zlatik.entity.ContainsArtist;
import com.example.zlatik.service.AlbumService;
import com.example.zlatik.service.ArtistService;
import com.example.zlatik.service.ContainsArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/containsartist")
public class ContainsArtistController {

    @Autowired
    ContainsArtistService containsArtistService;
    @Autowired
    ArtistService artistService;
    @Autowired
    AlbumService albumService;
    @Async
    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("containsartists", containsArtistService.getAll());
        model.addAttribute("artists", artistService.getAll());
        model.addAttribute("albums", albumService.getAll());
        return "containsartist";
    }
    @Async
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        ContainsArtist containsArtist = containsArtistService.getById(id);
        model.addAttribute("containsArtist", containsArtist);
        return "containsArtist-details";
    }
    @Async
    @PostMapping("/create")
    public String create(@ModelAttribute ContainsArtist containsArtist,
                         @RequestParam("albumName") String albumName,
                         @RequestParam("artistName") String artistName) {
        Album album = albumService.getByAlbumName(albumName);
        Artist artist = artistService.getByArtistName(artistName);
        containsArtist.setAlbum(album);
        containsArtist.setArtist(artist);
        containsArtistService.create(containsArtist);
        return "redirect:/containsartist";
    }
    @Async
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        containsArtistService.delete(id);
        return "redirect:/containsartist";
    }
    @Async
    @PostMapping("/save")
    public String save(@ModelAttribute("containsartist") ContainsArtist containsArtist) {
        containsArtistService.update(containsArtist);
        return "redirect:/containsartist";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getContainsArtist(@PathVariable("id") Long id, Model model) {
        ContainsArtist containsArtist = containsArtistService.getById(id);
        model.addAttribute("containsArtist", containsArtist);
        model.addAttribute("artists", artistService.getAll());
        model.addAttribute("albums", albumService.getAll());
        return "editcontainsartist";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editContainsArtist(@ModelAttribute ContainsArtist containsArtist,
                                     @RequestParam("albumName") String albumName,
                                     @RequestParam("artistName") String artistName) {
        Album album = albumService.getByAlbumName(albumName);
        Artist artist = artistService.getByArtistName(artistName);
        containsArtist.setAlbum(album);
        containsArtist.setArtist(artist);
        containsArtistService.update(containsArtist);
        return "redirect:/containsartist";
    }
}