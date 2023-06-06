package com.example.zlatik.controller;

import com.example.zlatik.entity.*;
import com.example.zlatik.service.AlbumService;
import com.example.zlatik.service.ContainsSongService;
import com.example.zlatik.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/containssong")
public class ContainsSongController {

    @Autowired
    ContainsSongService containsSongService;
    @Autowired
    SongService songService;
    @Autowired
    AlbumService albumService;
    @Async
    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("containssongs", containsSongService.getAll());
        model.addAttribute("songs", songService.getAll());
        model.addAttribute("albums", albumService.getAll());
        return "containssong";
    }
    @Async
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        ContainsSong containsSong = containsSongService.getById(id);
        model.addAttribute("containsSong", containsSong);
        return "containsSong-details";
    }
    @Async
    @PostMapping("/create")
    public String create(@RequestBody ContainsSong containsSong) {
        containsSongService.create(containsSong);
        return "redirect:/containssong";
    }
    @Async
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        containsSongService.delete(id);
        return "redirect:/containssong";
    }
    @Async
    @PostMapping("/save")
    public String save(@ModelAttribute("containssong") ContainsSong containsSong) {
        containsSongService.update(containsSong);
        return "redirect:/containssong";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getContainsSong(@PathVariable("id") Long id, Model model) {
        ContainsSong containsSong = containsSongService.getById(id);
        model.addAttribute("containsSong", containsSong);
        model.addAttribute("songs", songService.getAll());
        model.addAttribute("albums", albumService.getAll());
        return "editcontainssong";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editContainsSong(@ModelAttribute("id") ContainsSong containsSong) {
        containsSongService.update(containsSong);
        return "redirect:/containssong";
    }
}
