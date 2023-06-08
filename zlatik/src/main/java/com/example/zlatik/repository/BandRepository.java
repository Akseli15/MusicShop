package com.example.zlatik.repository;

import com.example.zlatik.entity.Artist;
import com.example.zlatik.entity.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band, Long> {
    Band findFirstByBandName(String bandName);
}
