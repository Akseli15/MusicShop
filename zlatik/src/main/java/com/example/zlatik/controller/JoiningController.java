package com.example.zlatik.controller;

import com.example.zlatik.entity.Artist;
import com.example.zlatik.entity.Band;
import com.example.zlatik.entity.Joining;
import com.example.zlatik.service.ArtistService;
import com.example.zlatik.service.BandService;
import com.example.zlatik.service.JoiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/joining")
public class JoiningController {
    @Autowired
    JoiningService joinService;
    @Autowired
    BandService bandService;
    @Autowired
    ArtistService artistService;

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("joinings", joinService.getAll());
        model.addAttribute("artists", artistService.getAll());
        model.addAttribute("bands", bandService.getAll());
        return "joining";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Joining joining = joinService.getById(id);
        model.addAttribute("joining", joining);
        return "joining-details";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Joining joining,
                         @RequestParam("artistName") String artistName,
                         @RequestParam("bandName") String bandName) {
        Artist artist = artistService.getByArtistName(artistName);
        joining.setArtist(artist);
        Band band = bandService.getByBandName(bandName);
        joining.setBand(band);
        joinService.create(joining);
        return "redirect:/joining";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        joinService.delete(id);
        return "redirect:/joining";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("joining") Joining joining) {
        joinService.update(joining);
        return "redirect:/joining";
    }

    @GetMapping("/edit/{id}")
    public String getJoin(@PathVariable("id") Long id, Model model) {
        Joining joining = joinService.getById(id);
        model.addAttribute("joining", joining);
        model.addAttribute("artists", artistService.getAll());
        model.addAttribute("bands", bandService.getAll());
        return "editjoining";
    }

    @PostMapping("/edit/{id}")
    public String editJoining(@ModelAttribute Joining joining,
                              @RequestParam("artistName") String artistName,
                              @RequestParam("bandName") String bandName) {
        Artist artist = artistService.getByArtistName(artistName);
        Band band = bandService.getByBandName(bandName);
        joining.setArtist(artist);
        joining.setBand(band);
        joinService.update(joining);
        return "redirect:/joining";
    }
}
