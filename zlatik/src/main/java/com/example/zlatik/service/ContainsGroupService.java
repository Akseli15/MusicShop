package com.example.zlatik.service;

import com.example.zlatik.entity.ContainsGroup;
import com.example.zlatik.repository.ContainsGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContainsGroupService {
    @Autowired
    ContainsGroupRepository containsGroupRepository;
    @Async
    public List<ContainsGroup> getAllContainsGroups() {
        return containsGroupRepository.findAll();
    }
    @Async
    public ContainsGroup getContainsGroupByTitle(Integer id) {
        return containsGroupRepository.findById(id).orElse(null);
    }
    @Async
    public ContainsGroup createContainsGroup(ContainsGroup containsGroup) {
        return containsGroupRepository.save(containsGroup);
    }
    @Async
    public void deleteContainsGroup(Integer id) {
        containsGroupRepository.deleteById(id);
    }
}
