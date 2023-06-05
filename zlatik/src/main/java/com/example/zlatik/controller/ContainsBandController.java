package com.example.zlatik.controller;

import com.example.zlatik.entity.*;
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
    @Async
    @GetMapping("/containsband")
    public String getAll(Model model) {
        model.addAttribute("containsbands", containsBandService.getAll());
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
    public String create(@RequestBody ContainsBand containsBand) {
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
        if (containsBand != null) {
            model.addAttribute("containsBand", containsBand);
        }
        return "editcontainsband";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editContainsBand(@PathVariable("id") Long id,
                                     @RequestParam(value = "band", required = false) Band band,
                                     @RequestParam(value = "album", required = false) Album album) {
        ContainsBand containsBand = containsBandService.getById(id);
        if (containsBand == null) {
            return "redirect:/containsband/edit/" + id + "?error=true";
        }
        if (band != null) {
            containsBand.setBand(band);
        }
        if (album != null) {
            containsBand.setAlbum(album);
        }
        containsBandService.update(containsBand);
        return "redirect:/containsband";
    }
}
