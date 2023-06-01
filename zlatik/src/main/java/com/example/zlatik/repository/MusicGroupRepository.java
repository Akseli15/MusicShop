package com.example.zlatik.repository;

import com.example.zlatik.entity.MusicGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicGroupRepository extends JpaRepository<MusicGroup, String> {
}
