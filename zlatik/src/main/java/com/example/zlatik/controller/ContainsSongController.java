package com.example.zlatik.controller;

import com.example.zlatik.entity.ContainsSong;
import com.example.zlatik.service.ContainsSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/containssong")
public class ContainsSongController {
    @Autowired
    ContainsSongService containsSongService;
    @Async
    @GetMapping
    public List<ContainsSong> getAllContainsSongs() {
        return containsSongService.getAllContainsSongs();
    }
    @Async
    @GetMapping("/{title}")
    public ContainsSong getContainsSongByTitle(@PathVariable("title") Integer title) {
        return containsSongService.getContainsSongByTitle(title);
    }
    @Async
    @PostMapping
    public ContainsSong createContainsSong(@RequestBody ContainsSong containsSong) {
        return containsSongService.createContainsSong(containsSong);
    }
    @Async
    @DeleteMapping("/{title}")
    public void deleteContainsSong(@PathVariable("title") Integer title) {
        containsSongService.deleteContainsSong(title);
    }
}
