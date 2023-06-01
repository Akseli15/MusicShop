package com.example.zlatik.controller;

import com.example.zlatik.entity.ContainsArtist;
import com.example.zlatik.service.ContainsArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/containsartist")
public class ContainsArtistController {
    @Autowired
    ContainsArtistService containsArtistService;
    @Async
    @GetMapping
    public List<ContainsArtist> getAllContainsArtists() {
        return containsArtistService.getAllContainsArtists();
    }
    @Async
    @GetMapping("/{title}")
    public ContainsArtist getContainsArtistByTitle(@PathVariable("title") Integer title) {
        return containsArtistService.getContainsArtistByTitle(title);
    }
    @Async
    @PostMapping
    public ContainsArtist createContainsArtist(@RequestBody ContainsArtist genre) {
        return containsArtistService.createContainsArtist(genre);
    }
    @Async
    @DeleteMapping("/{title}")
    public void deleteContainsArtist(@PathVariable("title") Integer title) {
        containsArtistService.deleteContainsArtist(title);
    }
}