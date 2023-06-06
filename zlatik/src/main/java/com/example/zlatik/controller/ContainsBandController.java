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
    @GetMapping("")
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
        model.addAttribute("containsBand", containsBand);
        return "editcontainsband";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editContainsBand(@ModelAttribute ContainsBand containsBand) {
        containsBandService.update(containsBand);
        return "redirect:/containsband";
    }
}
