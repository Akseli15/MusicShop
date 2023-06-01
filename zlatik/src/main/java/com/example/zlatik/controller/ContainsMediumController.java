package com.example.zlatik.controller;

import com.example.zlatik.entity.ContainsMedium;
import com.example.zlatik.service.ContainsMediumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/containsmedium")
public class ContainsMediumController {
    @Autowired
    ContainsMediumService containsMediumService;
    @Async
    @GetMapping
    public List<ContainsMedium> getAllContainsMediums() {
        return containsMediumService.getAllContainsMediums();
    }
    @Async
    @GetMapping("/{title}")
    public ContainsMedium getContainsMediumByTitle(@PathVariable("title") Integer title) {
        return containsMediumService.getContainsMediumByTitle(title);
    }
    @Async
    @PostMapping
    public ContainsMedium createContainsMedium(@RequestBody ContainsMedium containsMedium) {
        return containsMediumService.createContainsMedium(containsMedium);
    }
    @Async
    @DeleteMapping("/{title}")
    public void deleteContainsMedium(@PathVariable("title") Integer title) {
        containsMediumService.deleteContainsMedium(title);
    }
}
