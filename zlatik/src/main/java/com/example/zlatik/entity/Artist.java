package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "artist")
public class Artist {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_artist")
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT", name = "artist_name")
    private String artistName;

    public Artist() {
    }
    public Artist(Long id, String artistName) {
        this.id = id;
        this.artistName = artistName;
    }

    public Artist(String artistName) {
        this.artistName = artistName;
    }
}

