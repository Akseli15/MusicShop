package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

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
    @Column(columnDefinition = "DATE", name = "releasedate")
    private Date releaseDate;
    @Column(columnDefinition = "TIME", name = "album_duration")
    private Time albumDuration;

    public Album() {
    }
    public Album(Long id, String albumName, Date releaseDate, Time albumDuration) {
        this.id = id;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.albumDuration = albumDuration;
    }

    public Album(String albumName, Date releaseDate, Time albumDuration) {
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.albumDuration = albumDuration;
    }
}
