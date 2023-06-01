package com.example.zlatik.controller;

import com.example.zlatik.entity.ContainsGroup;
import com.example.zlatik.service.ContainsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/containsgroup")
public class ContainsGroupController {
    @Autowired
    ContainsGroupService containsGroupService;
    @Async
    @GetMapping
    public String getAllContainsGroups(Model model) {
        model.addAttribute("containsgroups", containsGroupService.getAllContainsGroups());
        return "containsgroup";
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
    @PostMapping("/delete/{id}")
    public String deleteContainsGroup(@PathVariable("id") Integer id) {
        containsGroupService.deleteContainsGroup(id);
        return "redirect:/containsgroup";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String editContainsGroup(@PathVariable("id") Integer id, Model model) {
        ContainsGroup containsGroup = containsGroupService.getContainsGroupByTitle(id);
        Map<String, Object> entityFields = createFieldsForContainsGroup(containsGroup);
        model.addAttribute("entity", entityFields);
        return "redirect:/";
    }

    private Map<String, Object> createFieldsForContainsGroup(ContainsGroup containsGroup) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("Название альбома", containsGroup.getAlbum());
        entityFields.put("Название группы", containsGroup.getMusicGroup());
        return entityFields;
    }
}
