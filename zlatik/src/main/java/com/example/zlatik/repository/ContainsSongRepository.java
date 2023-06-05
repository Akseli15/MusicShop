package com.example.zlatik.repository;

import com.example.zlatik.entity.ContainsSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainsSongRepository extends JpaRepository<ContainsSong, Long> {
}