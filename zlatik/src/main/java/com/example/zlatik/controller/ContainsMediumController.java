package com.example.zlatik.controller;

import com.example.zlatik.entity.ContainsMedium;
import com.example.zlatik.service.ContainsMediumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/containsmedium")
public class ContainsMediumController {
    @Autowired
    ContainsMediumService containsMediumService;
    @Async
    @GetMapping
    public String getAllContainsMediums(Model model) {
        model.addAttribute("containsmediums", containsMediumService.getAllContainsMediums());
        return "containsmedium";
    }
    @Async
    @GetMapping("/{title}")
    public ContainsMedium getContainsMediumByTitle(@PathVariable("title") Integer title) {
        return containsMediumService.getContainsMediumByTitle(title);
    }
    @Async
    @PostMapping
    public ContainsMedium createContainsMedium(@RequestBody ContainsMedium containsMedium) {
        return containsMediumService.createContainsMedium(containsMedium);
    }
    @Async
    @PostMapping("/delete/{id}")
    public String deleteContainsMedium(@PathVariable("id") Integer id) {
        containsMediumService.deleteContainsMedium(id);
        return "redirect:/containsmedium";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String editContainsGroup(@PathVariable("id") Integer id, Model model) {
        ContainsMedium containsMedium = containsMediumService.getContainsMediumByTitle(id);
        Map<String, Object> entityFields = createFieldsForContainsGroup(containsMedium);
        model.addAttribute("entity", entityFields);
        return "redirect:/";
    }

    private Map<String, Object> createFieldsForContainsGroup(ContainsMedium containsMedium) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("Название альбома", containsMedium.getAlbum());
        entityFields.put("ID накопителя", containsMedium.getMedium());
        return entityFields;
    }
}
