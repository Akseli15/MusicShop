package com.example.zlatik.controller;

import com.example.zlatik.entity.*;
import com.example.zlatik.service.AlbumService;
import com.example.zlatik.service.CarrierService;
import com.example.zlatik.service.RecordedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/recorded")
public class RecordedController {

    @Autowired
    RecordedService recordedService;
    @Autowired
    CarrierService carrierService;
    @Autowired
    AlbumService albumService;
    @Async
    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("recordeds", recordedService.getAll());
        model.addAttribute("albums", albumService.getAll());
        model.addAttribute("carriers", carrierService.getAll());
        return "recorded";
    }
    @Async
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Recorded recorded = recordedService.getById(id);
        model.addAttribute("recorded", recorded);
        return "recorded-details";
    }
    @Async
    @PostMapping("/create")
    public String create(@ModelAttribute Recorded recorded,
                         @RequestParam("albumName") String albumName,
                         @RequestParam("idCarrier") Long idCarrier) {
        Album album = albumService.getByAlbumName(albumName);
        recorded.setAlbum(album);
        Carrier carrier = carrierService.getById(idCarrier);
        recorded.setCarrier(carrier);
        recordedService.create(recorded);
        return "redirect:/recorded";
    }
    @Async
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        recordedService.delete(id);
        return "redirect:/recorded";
    }
    @Async
    @PostMapping("/save")
    public String save(@ModelAttribute("recorded") Recorded recorded) {
        recordedService.update(recorded);
        return "redirect:/recorded";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getRecorded(@PathVariable("id") Long id, Model model) {
        Recorded recorded = recordedService.getById(id);
        model.addAttribute("recorded", recorded);
        return "editrecorded";
    }
    @Async
    @PostMapping("/edit/{id}")
    public String editRecorded(@ModelAttribute Recorded recorded,
                               @RequestParam("albumName") String albumName,
                               @RequestParam("idCarrier") Long idCarrier) {
        Album album = albumService.getByAlbumName(albumName);
        recorded.setAlbum(album);
        Carrier carrier = carrierService.getById(idCarrier);
        recorded.setCarrier(carrier);
        recordedService.update(recorded);
        return "redirect:/recorded";
    }
}
