package com.example.zlatik.controller;

import com.example.zlatik.entity.*;
import com.example.zlatik.service.PerformsBandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/performsband")
public class PerformsBandController {
    @Autowired
    PerformsBandService performsBandService;
    @Async
    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("performsbands", performsBandService.getAll());
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
    public String create(@RequestBody PerformsBand performsBand) {
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
        return "editperformsband";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editPerformsBand(@ModelAttribute PerformsBand performsBand) {
        performsBandService.update(performsBand);
        return "redirect:/performsband";
    }
}
