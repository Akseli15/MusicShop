package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "album")
public class Album {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_album")
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT", name = "album_name")
    private String albumName;
    @Column(name = "releasedate")
    private LocalDate releaseDate;
    @Column(columnDefinition = "TIME", name = "album_duration")
    private Time albumDuration;
    @OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE)
    private List<ContainsArtist> containsArtists;
    @OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE)
    private List<ContainsBand> containsBands;
    @OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE)
    private List<ContainsSong> containsSongs;
    @OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE)
    private List<Recorded> recordeds;
    public Album() {
    }
    public Album(Long id, String albumName, LocalDate releaseDate, Time albumDuration) {
        this.id = id;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.albumDuration = albumDuration;
    }

    public Album(String albumName, LocalDate releaseDate, Time albumDuration) {
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.albumDuration = albumDuration;
    }
}
