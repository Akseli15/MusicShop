package com.example.zlatik.controller;

import com.example.zlatik.entity.Medium;
import com.example.zlatik.service.MediumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/medium")
public class MediumController {

    @Autowired
    MediumService mediumService;
    @Async
    @GetMapping
    public List<Medium> getAllMediums() {
        return mediumService.getAllMediums();
    }
    @Async
    @GetMapping("/{title}")
    public Medium getMediumByTitle(@PathVariable("title") Integer title) {
        return mediumService.getMediumByTitle(title);
    }
    @Async
    @PostMapping
    public Medium createMedium(@RequestBody Medium medium) {
        return mediumService.createMedium(medium);
    }
    @Async
    @DeleteMapping("/{title}")
    public void deleteMedium(@PathVariable("title") Integer title) {
        mediumService.deleteMedium(title);
    }

}
