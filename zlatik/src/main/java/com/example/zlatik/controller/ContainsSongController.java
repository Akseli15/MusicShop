package com.example.zlatik.controller;

import com.example.zlatik.entity.ContainsSong;
import com.example.zlatik.service.ContainsSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/containssong")
public class ContainsSongController {
    @Autowired
    ContainsSongService containsSongService;
    @Async
    @GetMapping
    public String getAllContainsSongs(Model model) {
        model.addAttribute("containssongs", containsSongService.getAllContainsSongs());
        return "containssong";
    }
    @Async
    @GetMapping("/{title}")
    public ContainsSong getContainsSongByTitle(@PathVariable("title") Integer title) {
        return containsSongService.getContainsSongByTitle(title);
    }
    @Async
    @PostMapping
    public ContainsSong createContainsSong(@RequestBody ContainsSong containsSong) {
        return containsSongService.createContainsSong(containsSong);
    }
    @Async
    @PostMapping("/delete/{id}")
    public String deleteContainsSong(@PathVariable("id") Integer id) {
        containsSongService.deleteContainsSong(id);
        return "redirect:/";
    }

    @Async
    @GetMapping("/edit/{id}")
    public String editContainsSong(@PathVariable("id") Integer id, Model model) {
        ContainsSong containsSong = containsSongService.getContainsSongByTitle(id);
        Map<String, Object> entityFields = createFieldsForAlbum(containsSong);
        model.addAttribute("entity", entityFields);
        return "redirect:/";
    }

    private Map<String, Object> createFieldsForAlbum(ContainsSong containsSong) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("ID", containsSong.getId());
        entityFields.put("Название альбома", containsSong.getAlbum());
        entityFields.put("Название песни", containsSong.getSong());
        return entityFields;
    }
}
