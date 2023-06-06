package com.example.zlatik.controller;

import com.example.zlatik.entity.Artist;
import com.example.zlatik.entity.Band;
import com.example.zlatik.entity.Join;
import com.example.zlatik.service.AlbumService;
import com.example.zlatik.service.BandService;
import com.example.zlatik.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("/join")
public class JoinController {

    @Autowired
    JoinService joinService;
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
        Join join = joinService.getById(id);
        model.addAttribute("join", join);
        return "join-details";
    }
    @Async
    @PostMapping("/create")
    public String create(@RequestBody Join join) {
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
    public String save(@ModelAttribute("join") Join join) {
        joinService.update(join);
        return "redirect:/join";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getJoin(@PathVariable("id") Long id, Model model) {
        Join join = joinService.getById(id);
        model.addAttribute("join", join);
        model.addAttribute("albums", albumService.getAll());
        model.addAttribute("bands", bandService.getAll());
        return "editjoin";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editJoin(@ModelAttribute Join join) {
        joinService.update(join);
        return "redirect:/join";
    }
}
