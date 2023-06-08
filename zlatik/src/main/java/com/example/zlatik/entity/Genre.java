package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @OneToMany(mappedBy = "genre", cascade = CascadeType.REMOVE)
    private List<Song> songs;

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

