package com.example.zlatik.repository;

import com.example.zlatik.entity.Recorded;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordedRepository extends JpaRepository <Recorded, Long> {
}
