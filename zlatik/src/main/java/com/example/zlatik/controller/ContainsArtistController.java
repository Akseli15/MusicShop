package com.example.zlatik.controller;

import com.example.zlatik.entity.ContainsArtist;
import com.example.zlatik.service.ContainsArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/containsartist")
public class ContainsArtistController {
    @Autowired
    ContainsArtistService containsArtistService;
    @Async
    @GetMapping
    public String getAllContainsArtists(Model model) {
        model.addAttribute("containsartists", containsArtistService.getAllContainsArtists());
        return "containsartist";
    }
    @Async
    @GetMapping("/{id}")
    public ContainsArtist getContainsArtistById(@PathVariable("id") Integer id) {
        return containsArtistService.getContainsArtistById(id);
    }
    @Async
    @PostMapping
    public ContainsArtist createContainsArtist(@RequestBody ContainsArtist containsArtist) {
        return containsArtistService.createContainsArtist(containsArtist);
    }
    @Async
    @PostMapping("/delete/{id}")
    public String deleteContainsArtist(@PathVariable("id") Integer id) {
        containsArtistService.deleteContainsArtist(id);
        return "redirect:/containsartist";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String editContainsArtist(@PathVariable("id") Integer id, Model model) {
        ContainsArtist containsArtist = containsArtistService.getContainsArtistById(id);
        Map<String, Object> entityFields = createFieldsForArtist(containsArtist);
        model.addAttribute("entity", entityFields);
        return "redirect:/";
    }

    private Map<String, Object> createFieldsForArtist(ContainsArtist containsArtist) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("Название альбома", containsArtist.getAlbum());
        entityFields.put("ФИО", containsArtist.getArtist());
        return entityFields;
    }
}