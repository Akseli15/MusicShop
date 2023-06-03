package com.example.zlatik.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "Альбом")
public class Album {
    @Id
    @Column(name = "ID_название_альбома")
    private String id;

    @Column(name = "Дата_выпуска")
    private LocalDate releaseDate;

    @Column(name = "Продолжительность_альбома")
    private Time duration;

    public Album() {
    }

    public Album(String id, LocalDate releaseDate, Time duration) {
        this.id = id;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public Time getDuration() {
        return duration;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    public void setDuration(Time duration) {
        this.duration = duration;
    }
}
