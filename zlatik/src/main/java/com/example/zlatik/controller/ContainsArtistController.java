package com.example.zlatik.controller;

import com.example.zlatik.entity.Album;
import com.example.zlatik.entity.Artist;
import com.example.zlatik.entity.ContainsArtist;
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
    @Async
    @GetMapping("/containsartist")
    public String getAll(Model model) {
        model.addAttribute("containsartists", containsArtistService.getAll());
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
    public String create(@RequestBody ContainsArtist containsArtist) {
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
        if (containsArtist != null) {
            model.addAttribute("containsArtist", containsArtist);
        }
        return "editcontainsartist";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editContainsArtist(@PathVariable("id") Long id,
                            @RequestParam(value = "artist", required = false) Artist artist,
                            @RequestParam(value = "album", required = false) Album album) {
        ContainsArtist containsArtist = containsArtistService.getById(id);
        if (containsArtist == null) {
            return "redirect:/containsartist/edit/" + id + "?error=true";
        }
        if (artist != null) {
            containsArtist.setArtist(artist);
        }
        if (album != null) {
            containsArtist.setAlbum(album);
        }
        containsArtistService.update(containsArtist);
        return "redirect:/containsartist";
    }
}