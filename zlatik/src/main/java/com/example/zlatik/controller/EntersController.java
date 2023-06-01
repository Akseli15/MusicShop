package com.example.zlatik.controller;

import com.example.zlatik.entity.Enters;
import com.example.zlatik.service.EntersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enters")
public class EntersController {
    @Autowired
    EntersService entersService;
    @Async
    @GetMapping
    public List<Enters> getAllEnters() {
        return entersService.getAllEnters();
    }
    @Async
    @GetMapping("/{title}")
    public Enters getEntersByTitle(@PathVariable("title") Integer title) {
        return entersService.getEntersByTitle(title);
    }
    @Async
    @PostMapping
    public Enters createEnters(@RequestBody Enters enters) {
        return entersService.createEnters(enters);
    }
    @Async
    @DeleteMapping("/{title}")
    public void deleteEnters(@PathVariable("title") Integer title) {
        entersService.deleteEnters(title);
    }

}
