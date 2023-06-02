package com.example.zlatik.controller;

import com.example.zlatik.entity.PerformsGroup;
import com.example.zlatik.service.PerformsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/performsgroup")
public class PerformsGroupController {
    @Autowired
    PerformsGroupService performsGroupService;
    @Async
    @GetMapping
    public String getAllPerformsGroups(Model model) {
        model.addAttribute("performsgroups", performsGroupService.getAllPerformsGroups());
        return "performsgroup";
    }
    @Async
    @GetMapping("/{id}")
    public PerformsGroup getPerformsGroupByTitle(@PathVariable("id") Integer id) {
        return performsGroupService.getPerformsGroupByTitle(id);
    }
    @Async
    @PostMapping
    public PerformsGroup createPerformsGroup(@RequestBody PerformsGroup musicGroup) {
        return performsGroupService.createPerformsGroup(musicGroup);
    }
    @Async
    @PostMapping("/delete/{id}")
    public String deletePerformsGroup(@PathVariable("id") Integer id) {
        performsGroupService.deletePerformsGroup(id);
        return "redirect:/performsgroup";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String editPerformsGroup(@PathVariable("id") Integer id, Model model) {
        PerformsGroup performsGroup = performsGroupService.getPerformsGroupByTitle(id);
        Map<String, Object> entityFields = createFieldsForContainsGroup(performsGroup);
        model.addAttribute("entity", entityFields);
        return "redirect:/performsgroup";
    }

    private Map<String, Object> createFieldsForContainsGroup(PerformsGroup performsGroup) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("ID", performsGroup.getId());
        entityFields.put("Название песни", performsGroup.getSong());
        entityFields.put("Имя исполнителя", performsGroup.getMusicGroup());
        return entityFields;
    }
}
