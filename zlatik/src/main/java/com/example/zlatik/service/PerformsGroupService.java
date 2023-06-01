package com.example.zlatik.service;

import com.example.zlatik.entity.PerformsGroup;
import com.example.zlatik.repository.PerformsGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PerformsGroupService {
    @Autowired
    PerformsGroupRepository performsGroupRepository;
    @Async
    public List<PerformsGroup> getAllPerformsGroups() {
        return performsGroupRepository.findAll();
    }
    @Async
    public PerformsGroup getPerformsGroupByTitle(Integer id) {
        return performsGroupRepository.findById(id).orElse(null);
    }
    @Async
    public PerformsGroup createPerformsGroup(PerformsGroup performsGroup) {
        return performsGroupRepository.save(performsGroup);
    }
    @Async
    public void deletePerformsGroup(Integer id) {
        performsGroupRepository.deleteById(id);
    }
}
