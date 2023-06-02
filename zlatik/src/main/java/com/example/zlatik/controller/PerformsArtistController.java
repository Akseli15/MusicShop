package com.example.zlatik.controller;

import com.example.zlatik.entity.PerformsArtist;
import com.example.zlatik.service.PerformsArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/performsartist")
public class PerformsArtistController {
    @Autowired
    PerformsArtistService performsArtistService;
    @Async
    @GetMapping
    public String getAllPerformsArtists(Model model) {
        model.addAttribute("performsartists", performsArtistService.getAllPerformsArtists());
        return "performsartist";
    }
    @Async
    @GetMapping("/{id}")
    public PerformsArtist getPerformsArtistByTitle(@PathVariable("id") Integer id) {
        return performsArtistService.getPerformsArtistByTitle(id);
    }
    @Async
    @PostMapping
    public PerformsArtist createPerformsArtist(@RequestBody PerformsArtist performsArtist) {
        return performsArtistService.createPerformsArtist(performsArtist);
    }
    @Async
    @PostMapping("/delete/{id}")
    public String deletePerformsArtist(@PathVariable("id") Integer id) {
        performsArtistService.deletePerformsArtist(id);
        return "redirect:/performsartist";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String editPerformsArtist(@PathVariable("id") Integer id, Model model) {
        PerformsArtist performsArtist = performsArtistService.getPerformsArtistByTitle(id);
        Map<String, Object> entityFields = createFieldsForContainsGroup(performsArtist);
        model.addAttribute("entity", entityFields);
        return "redirect:/performsartist";
    }

    private Map<String, Object> createFieldsForContainsGroup(PerformsArtist performsArtist) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("ID", performsArtist.getId());
        entityFields.put("Название песни", performsArtist.getSong());
        entityFields.put("Имя исполнителя", performsArtist.getArtist());
        return entityFields;
    }
}