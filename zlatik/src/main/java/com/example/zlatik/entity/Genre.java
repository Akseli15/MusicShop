package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genre")
    private Long id;
    @Column(name = "genre_name")
    private String genreName;

    public Genre() {
    }
    public Genre(Long id, String genreName) {
        this.id = id;
        this.genreName = genreName;
    }
    public Genre(String genreName) {
        this.genreName = genreName;
    }
}

