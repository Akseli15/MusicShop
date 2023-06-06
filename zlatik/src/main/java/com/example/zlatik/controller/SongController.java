package com.example.zlatik.controller;

import com.example.zlatik.entity.Album;
import com.example.zlatik.entity.Artist;
import com.example.zlatik.entity.Genre;
import com.example.zlatik.entity.Song;
import com.example.zlatik.service.GenreService;
import com.example.zlatik.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    SongService songService;
    @Autowired
    GenreService genreService;
    @Async
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("songs", songService.getAll());
        model.addAttribute("genres", genreService.getAll());
        return "song";
    }
    @Async
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Song song = songService.getById(id);
        model.addAttribute("song", song);
        return "song-details";
    }
    @Async
    @PostMapping("/create")
    public String create(@ModelAttribute Song song){
        songService.create(song);
        return "redirect:/song";
    }
    @Async
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        songService.delete(id);
        return "redirect:/song";
    }
    @Async
    @PostMapping("/save")
    public String save(@ModelAttribute("song") Song song) {
        songService.update(song);
        return "redirect:/song";
    }
    @GetMapping("/edit/{id}")
    public String getSong(@PathVariable("id") Long id, Model model) {
        Song song = songService.getById(id);
        model.addAttribute("song", song);
        model.addAttribute("genres", genreService.getAll());
        return "editsong";
    }

    @PostMapping("/edit")
    public String editSong(@ModelAttribute Song song) {
        songService.update(song);
        return "redirect:/song";
    }
}
