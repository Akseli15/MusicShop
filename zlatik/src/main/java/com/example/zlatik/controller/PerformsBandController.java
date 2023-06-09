package com.example.zlatik.controller;

import com.example.zlatik.entity.*;
import com.example.zlatik.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/performsband")
public class PerformsBandController {

    @Autowired
    PerformsBandService performsBandService;
    @Autowired
    BandService bandService;
    @Autowired
    SongService songService;
    @Async
    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("performsbands", performsBandService.getAll());
        model.addAttribute("songs", songService.getAll());
        model.addAttribute("bands", bandService.getAll());
        return "performsband";
    }
    @Async
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        PerformsBand performsBand = performsBandService.getById(id);
        model.addAttribute("performsBand", performsBand);
        return "performsBand-details";
    }
    @Async
    @PostMapping("/create")
    public String create(@ModelAttribute PerformsBand performsBand,
                         @RequestParam("songName") String songName,
                         @RequestParam("bandName") String bandName) {
        Song song = songService.getBySongName(songName);
        Band band = bandService.getByBandName(bandName);
        performsBand.setSong(song);
        performsBand.setBand(band);
        performsBandService.create(performsBand);
        return "redirect:/performsband";
    }
    @Async
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        performsBandService.delete(id);
        return "redirect:/performsband";
    }
    @Async
    @PostMapping("/save")
    public String save(@ModelAttribute("performsband") PerformsBand performsBand) {
        performsBandService.update(performsBand);
        return "redirect:/performsband";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getPerformsBand(@PathVariable("id") Long id, Model model) {
        PerformsBand performsBand = performsBandService.getById(id);
        model.addAttribute("performsBand", performsBand);
        model.addAttribute("songs", songService.getAll());
        model.addAttribute("bands", bandService.getAll());
        return "editperformsband";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editPerformsBand(@ModelAttribute PerformsBand performsBand,
                                   @RequestParam("songName") String songName,
                                   @RequestParam("bandName") String bandName) {
        Song song = songService.getBySongName(songName);
        Band band = bandService.getByBandName(bandName);
        performsBand.setSong(song);
        performsBand.setBand(band);
        performsBandService.update(performsBand);
        return "redirect:/performsband";
    }
}
