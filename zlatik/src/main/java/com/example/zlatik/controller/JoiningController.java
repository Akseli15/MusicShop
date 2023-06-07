package com.example.zlatik.controller;

import com.example.zlatik.entity.Joining;
import com.example.zlatik.service.AlbumService;
import com.example.zlatik.service.BandService;
import com.example.zlatik.service.JoiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/join")
public class JoiningController {

    @Autowired
    JoiningService joinService;
    @Autowired
    BandService bandService;
    @Autowired
    AlbumService albumService;
    @Async
    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("joins", joinService.getAll());
        model.addAttribute("albums", albumService.getAll());
        model.addAttribute("bands", bandService.getAll());
        return "join";
    }
    @Async
    @GetMapping("/{id}")
    public String getById(@PathVariable("title") Long id, Model model) {
        Joining join = joinService.getById(id);
        model.addAttribute("join", join);
        return "join-details";
    }
    @Async
    @PostMapping("/create")
    public String create(@RequestBody Joining join) {
        joinService.create(join);
        return "redirect:/join";
    }
    @Async
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        joinService.delete(id);
        return "redirect:/join";
    }
    @Async
    @PostMapping("/save")
    public String save(@ModelAttribute("join") Joining join) {
        joinService.update(join);
        return "redirect:/join";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getJoin(@PathVariable("id") Long id, Model model) {
        Joining join = joinService.getById(id);
        model.addAttribute("join", join);
        model.addAttribute("albums", albumService.getAll());
        model.addAttribute("bands", bandService.getAll());
        return "editjoin";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editJoin(@ModelAttribute Joining join) {
        joinService.update(join);
        return "redirect:/join";
    }
}
