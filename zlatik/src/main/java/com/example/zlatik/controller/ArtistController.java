package com.example.zlatik.controller;

import com.example.zlatik.entity.Artist;
import com.example.zlatik.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    @GetMapping("/{title}")
    public Artist getArtistByTitle(@PathVariable("title") String title) {
        return artistService.getArtistByTitle(title);
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
    public String editArtist(@PathVariable("id") String id, Model model) {
        Artist artist = artistService.getArtistByTitle(id);
        Map<String, Object> entityFields = createFieldsForArtist(artist);
        model.addAttribute("entity", entityFields);
        return "redirect:/";
    }

    private Map<String, Object> createFieldsForArtist(Artist artist) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("ФИО", artist.getFullName());
        return entityFields;
    }
}
