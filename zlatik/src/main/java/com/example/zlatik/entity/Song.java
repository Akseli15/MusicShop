package com.example.zlatik.entity;

import jakarta.persistence.*;

import java.sql.Time;


@Entity
@Table(name = "Песня")
public class Song {
    @Id
    @Column(name = "Название_песни")
    private String title;

    @Column(name = "Автор")
    private String author;

    @Column(name = "Продолжительность_песни")
    private Time duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_ID_жанра")
    private Genre genre;

    public Song() {
    }

    public Song(String title, String author, Time duration, Genre genre) {
        this.title = title;
        this.author = author;
        this.duration = duration;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Time getDuration() {
        return duration;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setDuration(Time duration) {
        this.duration = duration;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}

