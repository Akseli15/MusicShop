package com.example.zlatik.controller;

import com.example.zlatik.entity.ContainsGroup;
import com.example.zlatik.service.ContainsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/containsgroup")
public class ContainsGroupController {
    @Autowired
    ContainsGroupService containsGroupService;
    @Async
    @GetMapping
    public List<ContainsGroup> getAllContainsGroups() {
        return containsGroupService.getAllContainsGroups();
    }
    @Async
    @GetMapping("/{title}")
    public ContainsGroup getContainsGroupByTitle(@PathVariable("title") Integer title) {
        return containsGroupService.getContainsGroupByTitle(title);
    }
    @Async
    @PostMapping
    public ContainsGroup createContainsGroup(@RequestBody ContainsGroup containsGroup) {
        return containsGroupService.createContainsGroup(containsGroup);
    }
    @Async
    @DeleteMapping("/{title}")
    public void deleteContainsGroup(@PathVariable("title") Integer title) {
        containsGroupService.deleteContainsGroup(title);
    }
}
