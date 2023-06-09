package com.example.zlatik.controller;

import com.example.zlatik.entity.*;
import com.example.zlatik.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/performsartist")
public class PerformsArtistController {

    @Autowired
    PerformsArtistService performsArtistService;
    @Autowired
    SongService songService;
    @Autowired
    ArtistService artistService;
    @Async
    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("performsartists", performsArtistService.getAll());
        model.addAttribute("songs", songService.getAll());
        model.addAttribute("artists", artistService.getAll());
        return "performsartist";
    }
    @Async
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        PerformsArtist performsArtist = performsArtistService.getById(id);
        model.addAttribute("performsArtist", performsArtist);
        return "performsArtist-details";
    }
    @Async
    @PostMapping("/create")
    public String create(@ModelAttribute PerformsArtist performsArtist,
                         @RequestParam("songName") String songName,
                         @RequestParam("artistName") String artistName) {
        Song song = songService.getBySongName(songName);
        Artist artist = artistService.getByArtistName(artistName);
        performsArtist.setSong(song);
        performsArtist.setArtist(artist);
        performsArtistService.create(performsArtist);
        return "redirect:/performsartist";
    }
    @Async
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        performsArtistService.delete(id);
        return "redirect:/performsartist";
    }
    @Async
    @PostMapping("/save")
    public String save(@ModelAttribute("performsartist") PerformsArtist performsArtist) {
        performsArtistService.update(performsArtist);
        return "redirect:/performsartist";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getPerformsArtist(@PathVariable("id") Long id, Model model) {
        PerformsArtist performsArtist = performsArtistService.getById(id);
        model.addAttribute("performsArtist", performsArtist);
        model.addAttribute("songs", songService.getAll());
        model.addAttribute("artists", artistService.getAll());
        return "editperformsartist";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editPerformsArtist(@ModelAttribute PerformsArtist performsArtist,
                                     @RequestParam("songName") String songName,
                                     @RequestParam("artistName") String artistName) {
        Song song = songService.getBySongName(songName);
        Artist artist = artistService.getByArtistName(artistName);
        performsArtist.setSong(song);
        performsArtist.setArtist(artist);
        performsArtistService.update(performsArtist);
        return "redirect:/performsartist";
    }
}