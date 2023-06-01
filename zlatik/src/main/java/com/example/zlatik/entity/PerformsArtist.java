package com.example.zlatik.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Исполняет")
public class PerformsArtist {
    @Id
    @Column(name = "ID_исполняет")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_ID_песни", referencedColumnName = "Название_песни", foreignKey = @ForeignKey(name = "fk_ID_песни"))
    private Song song;

    @ManyToOne
    @JoinColumn(name = "fk_ID_исполнителя", referencedColumnName = "ФИО", foreignKey = @ForeignKey(name = "fk_ID_исполнителя"))
    private Artist artist;

    public PerformsArtist() {
    }

    public PerformsArtist(Integer id, Song song, Artist artist) {
        this.id = id;
        this.song = song;
        this.artist = artist;
    }

    public Integer getId() {
        return id;
    }
    public Song getSong() {
        return song;
    }
    public Artist getArtist() {
        return artist;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setSong(Song song) {
        this.song = song;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}

