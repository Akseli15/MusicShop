package com.example.zlatik.controller;

import com.example.zlatik.entity.Medium;
import com.example.zlatik.service.MediumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/medium")
public class MediumController {

    @Autowired
    MediumService mediumService;
    @Async
    @GetMapping
    public String getAllMediums(Model model) {
        model.addAttribute("mediums", mediumService.getAllMediums());
        return "medium";
    }
    @Async
    @GetMapping("/{title}")
    public Medium getMediumByTitle(@PathVariable("title") Integer title) {
        return mediumService.getMediumByTitle(title);
    }
    @Async
    @PostMapping
    public Medium createMedium(@RequestBody Medium medium) {
        return mediumService.createMedium(medium);
    }
    @Async
    @PostMapping("/delete/{id}")
    public String deleteMedium(@PathVariable("id") Integer id) {
        mediumService.deleteMedium(id);
        return "redirect:/medium";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String editMedium(@PathVariable("id") Integer id, Model model) {
        Medium medium = mediumService.getMediumByTitle(id);
        Map<String, Object> entityFields = createFieldsForContainsGroup(medium);
        model.addAttribute("entity", entityFields);
        return "redirect:/medium";
    }

    private Map<String, Object> createFieldsForContainsGroup(Medium medium) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("Тип носителя", medium.getType());
        entityFields.put("Издатель", medium.getPublisher());
        return entityFields;
    }
}
