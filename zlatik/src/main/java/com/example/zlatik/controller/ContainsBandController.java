package com.example.zlatik.controller;

import com.example.zlatik.entity.*;
import com.example.zlatik.service.AlbumService;
import com.example.zlatik.service.BandService;
import com.example.zlatik.service.ContainsBandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/containsband")
public class ContainsBandController {

    @Autowired
    ContainsBandService containsBandService;
    @Autowired
    BandService bandService;
    @Autowired
    AlbumService albumService;
    @Async
    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("containsbands", containsBandService.getAll());
        model.addAttribute("bands", bandService.getAll());
        model.addAttribute("albums", albumService.getAll());
        return "containsband";
    }
    @Async
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        ContainsBand containsBand = containsBandService.getById(id);
        model.addAttribute("containsBand", containsBand);
        return "containsband-details";
    }
    @Async
    @PostMapping("/create")
    public String create(@ModelAttribute ContainsBand containsBand,
                         @RequestParam ("albumName") String albumName,
                         @RequestParam ("bandName") String bandName) {
        Album album = albumService.getByAlbumName(albumName);
        Band band = bandService.getByBandName(bandName);
        containsBand.setAlbum(album);
        containsBand.setBand(band);
        containsBandService.create(containsBand);
        return "redirect:/containsband";
    }
    @Async
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        containsBandService.delete(id);
        return "redirect:/containsband";
    }
    @Async
    @PostMapping("/save")
    public String save(@ModelAttribute("containsband") ContainsBand containsBand) {
        containsBandService.update(containsBand);
        return "redirect:/containsband";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getContainsBand(@PathVariable("id") Long id, Model model) {
        ContainsBand containsBand = containsBandService.getById(id);
        model.addAttribute("containsBand", containsBand);
        model.addAttribute("bands", bandService.getAll());
        model.addAttribute("albums", albumService.getAll());
        return "editcontainsband";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editContainsBand(@ModelAttribute ContainsBand containsBand,
                                   @RequestParam ("albumName") String albumName,
                                   @RequestParam ("bandName") String bandName) {
        Album album = albumService.getByAlbumName(albumName);
        Band band = bandService.getByBandName(bandName);
        containsBand.setAlbum(album);
        containsBand.setBand(band);
        containsBandService.update(containsBand);
        return "redirect:/containsband";
    }
}
