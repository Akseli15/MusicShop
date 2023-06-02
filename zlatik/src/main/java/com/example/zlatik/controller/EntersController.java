package com.example.zlatik.controller;

import com.example.zlatik.entity.ContainsMedium;
import com.example.zlatik.entity.Enters;
import com.example.zlatik.service.EntersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/enters")
public class EntersController {
    @Autowired
    EntersService entersService;
    @Async
    @GetMapping
    public String getAllEnters(Model model) {
        model.addAttribute("enters", entersService.getAllEnters());
        return "enters";
    }
    @Async
    @GetMapping("/{title}")
    public Enters getEntersByTitle(@PathVariable("title") Integer title) {
        return entersService.getEntersByTitle(title);
    }
    @Async
    @PostMapping
    public Enters createEnters(@RequestBody Enters enters) {
        return entersService.createEnters(enters);
    }
    @Async
    @PostMapping("/delete/{id}")
    public String deleteEnters(@PathVariable("id") Integer id) {
        entersService.deleteEnters(id);
        return "redirect:/enters";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String editEnters(@PathVariable("id") Integer id, Model model) {
        Enters enters = entersService.getEntersByTitle(id);
        Map<String, Object> entityFields = createFieldsForContainsGroup(enters);
        model.addAttribute("entity", entityFields);
        return "redirect:/";
    }

    private Map<String, Object> createFieldsForContainsGroup(Enters enters) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("Имя исполнителя", enters.getArtist());
        entityFields.put("Название группы", enters.getMusicGroup());
        return entityFields;
    }

}
