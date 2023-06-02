package com.example.zlatik.controller;

import com.example.zlatik.entity.Song;
import com.example.zlatik.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    SongService songService;
    @Async
    @GetMapping
    public String getAllSongs(Model model) {
        model.addAttribute("songs", songService.getAllSongs());
        return "song";
    }
    @Async
    @GetMapping("/{id}")
    public Song getSongByTitle(@PathVariable("id") String id) {
        return songService.getSongByTitle(id);
    }
    @Async
    @PostMapping
    public Song createSongp(@RequestBody Song musicGroup) {
        return songService.createSong(musicGroup);
    }
    @Async
    @PostMapping("/delete/{id}")
    public String deleteSong(@PathVariable("id") String id) {
        songService.deleteSong(id);
        return "redirect:/song";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String editSong(@PathVariable("id") String id, Model model) {
        Song song = songService.getSongByTitle(id);
        Map<String, Object> entityFields = createFieldsForContainsGroup(song);
        model.addAttribute("entity", entityFields);
        return "redirect:/song";
    }

    private Map<String, Object> createFieldsForContainsGroup(Song song) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("Название песни", song.getTitle());
        entityFields.put("Автор", song.getAuthor());
        entityFields.put("Продолжительность", song.getDuration());
        entityFields.put("Жанр", song.getGenre());
        return entityFields;
    }
}
