package com.example.zlatik.controller;

import com.example.zlatik.entity.Medium;
import com.example.zlatik.entity.MusicGroup;
import com.example.zlatik.service.MusicGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/musicgroup")
public class MusicGroupController {
    @Autowired
    MusicGroupService musicGroupService;
    @Async
    @GetMapping
    public String getAllMusicGroups(Model model) {
        model.addAttribute("musicgroups", musicGroupService.getAllMusicGroups());
        return "musicgroup";
    }
    @Async
    @GetMapping("/{title}")
    public MusicGroup getMusicGroupByTitle(@PathVariable("title") String title) {
        return musicGroupService.getMusicGroupByTitle(title);
    }
    @Async
    @PostMapping
    public MusicGroup createMusicGroup(@RequestBody MusicGroup musicGroup) {
        return musicGroupService.createMusicGroup(musicGroup);
    }
    @Async
    @PostMapping("/delete/{id}")
    public String deleteMusicGroup(@PathVariable("id") String id) {
        musicGroupService.deleteMusicGroup(id);
        return "redirect:/musicgroup";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String editMusicGroup(@PathVariable("id") String id, Model model) {
        MusicGroup musicGroup = musicGroupService.getMusicGroupByTitle(id);
        Map<String, Object> entityFields = createFieldsForContainsGroup(musicGroup);
        model.addAttribute("entity", entityFields);
        return "redirect:/musicgroup";
    }

    private Map<String, Object> createFieldsForContainsGroup(MusicGroup musicGroup) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("Название альбома", musicGroup.getName());
        return entityFields;
    }
}
