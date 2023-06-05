package com.example.zlatik.controller;

import com.example.zlatik.entity.Band;
import com.example.zlatik.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/band")
public class BandController {
    @Autowired
    BandService bandService;
    @Async
    @GetMapping("/band")
    public String getAll(Model model) {
        model.addAttribute("bands", bandService.getAll());
        return "band";
    }
    @Async
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Band band = bandService.getById(id);
        model.addAttribute("band",band);
        return "band-details";
    }
    @Async
    @PostMapping("/create")
    public String create(@ModelAttribute Band band) {
        bandService.create(band);
        return "redirect:/band";
    }
    @Async
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        bandService.delete(id);
        return "redirect:/band";
    }
    @Async
    @PostMapping("/save")
    public String save(@ModelAttribute("musicgroup") Band band) {
        bandService.update(band);
        return "redirect:/band";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getBand(@PathVariable("id") Long id, Model model) {
        Band band = bandService.getById(id);
        if (band != null) {
            model.addAttribute("band", band);
        }
        return "editband";
    }

    @Async
    @PostMapping("/edit/{id}")
    public String editBand(@PathVariable("id") Long id,
                             @RequestParam(value = "bandName", required = false) String bandName) {
        Band band = bandService.getById(id);
        if (band == null) {
            return "redirect:/band/edit" + id + "?error=true";
        }
        if (bandName != null) {
            band.setBandName(bandName);
        }
        bandService.update(band);
        return "redirect:/band";
    }
}
