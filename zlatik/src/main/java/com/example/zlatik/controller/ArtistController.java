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
    ArtistService artistService;
    @Async
    @GetMapping("/artist")
    public String getAll(Model model) {
        model.addAttribute("artists", artistService.getAll());
        return "artist";
    }
    @Async
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Artist artist = artistService.getById(id);
        model.addAttribute("artist",artist);
        return "artist-details";
    }
    @Async
    @PostMapping("/create")
    public String create(@ModelAttribute Artist artist){
        artistService.create(artist);
        return "redirect:/artist";
    }
    @Async
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        artistService.delete(id);
        return "redirect:/artist";
    }
    @Async
    @PostMapping("/save")
    public String save(@ModelAttribute("artist") Artist artist) {
        artistService.update(artist);
        return "redirect:/artist";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getArtist(@PathVariable("id") Long id, Model model) {
        Artist artist = artistService.getById(id);
        if (artist != null) {
            model.addAttribute("artist", artist);
        }
        return "editartist";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editArtist(@PathVariable("id") Long id,
                            @RequestParam(value = "artistName", required = false) String artistName) {
        Artist artist = artistService.getById(id);
        if (artist == null) {
            return "redirect:/artist/edit" + id + "?error=true";
        }
        if (artistName != null) {
            artist.setArtistName(artistName);
        }
        artistService.update(artist);
        return "redirect:/artist";
    }
}
