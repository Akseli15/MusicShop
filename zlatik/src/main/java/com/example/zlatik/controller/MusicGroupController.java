package com.example.zlatik.controller;

import com.example.zlatik.entity.MusicGroup;
import com.example.zlatik.service.MusicGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/musicgroup")
public class MusicGroupController {
    @Autowired
    MusicGroupService musicGroupService;
    @Async
    @GetMapping
    public List<MusicGroup> getAllMusicGroups() {
        return musicGroupService.getAllMusicGroups();
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
    @DeleteMapping("/{title}")
    public void deleteMusicGroup(@PathVariable("title") String title) {
        musicGroupService.deleteMusicGroup(title);
    }
    @Async
    @GetMapping("/album/edit")
    public String editAlbum(@PathVariable("id") String id, Model model) {
        MusicGroup musicGroup = musicGroupService.getMusicGroupByTitle(id);
        Map<String, Object> entityFields = createFieldsForArtist(musicGroup);
        model.addAttribute("entity", entityFields);
        return "edit-entity";
    }

    private Map<String, Object> createFieldsForArtist(MusicGroup musicGroup) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("Название", musicGroup.getName());
        return entityFields;
    }
}
