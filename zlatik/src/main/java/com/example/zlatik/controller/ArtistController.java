package com.example.zlatik.controller;

import com.example.zlatik.entity.Album;
import com.example.zlatik.entity.Artist;
import com.example.zlatik.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/artist")
public class ArtistController {
    @Autowired
    ArtistService artistService;
    @Async
    @GetMapping
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }
    @Async
    @GetMapping("/{title}")
    public Artist getArtistByTitle(@PathVariable("title") String title) {
        return artistService.getArtistByTitle(title);
    }
    @Async
    @PostMapping
    public Artist createArtist(@RequestBody Artist genre) {
        return artistService.createArtist(genre);
    }
    @Async
    @DeleteMapping("/{title}")
    public void deleteArtist(@PathVariable("title") String title) {
        artistService.deleteArtist(title);
    }
    @Async
    @GetMapping("/artist/edit")
    public String editArtist(@PathVariable("id") String id, Model model) {
        Artist artist = artistService.getArtistByTitle(id);
        Map<String, Object> entityFields = createFieldsForArtist(artist);
        model.addAttribute("entity", entityFields);
        return "edit-entity";
    }

    private Map<String, Object> createFieldsForArtist(Artist artist) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("ФИО", artist.getFullName());
        return entityFields;
    }
}
