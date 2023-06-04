package com.example.zlatik.controller;

import com.example.zlatik.entity.Artist;
import com.example.zlatik.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artist")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @Async
    @GetMapping
    public String getAllArtists(Model model) {
        model.addAttribute("artists", artistService.getAllArtists());
        return "artist";
    }

    @Async
    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable("id") String id) {
        return artistService.getArtistById(id);
    }

    @Async
    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.createArtist(artist);
    }

    @Async
    @PostMapping("/delete/{id}")
    public String deleteArtist(@PathVariable("id") String id) {
        artistService.deleteArtist(id);
        return "redirect:/artist";
    }

    @Async
    @GetMapping("/edit/{id}")
    public String getArtist(@PathVariable("id") String id, Model model) {
        Artist artist = artistService.getArtistById(id);
        if (artist != null) {
            model.addAttribute("artist", artist);
        }
        return "editartist";
    }

    @Async
    @PostMapping("/edit/{id}")
    public String editArtist(@PathVariable("id") String id,
                            @RequestParam(value = "newFullName", required = false) String newFullName) {
        Artist artist = artistService.getArtistById(id);
        if (artist == null) {
            return "redirect:/artist/edit" + id + "?error=true";
        }
        if (newFullName != null) {
            artist.setFullName(newFullName);
        }
        artistService.saveArtist(artist);
        return "redirect:/artist";
    }
}
