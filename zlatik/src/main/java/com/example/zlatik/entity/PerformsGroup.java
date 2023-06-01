package com.example.zlatik.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Исполняет_группа")
public class PerformsGroup {
    @Id
    @Column(name = "ID_исполняет_группа")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_ID_песни", referencedColumnName = "Название_песни", foreignKey = @ForeignKey(name = "fk_ID_песни"))
    private Song song;

    @ManyToOne
    @JoinColumn(name = "fk_ID_музыкальной_группы", referencedColumnName = "Название", foreignKey = @ForeignKey(name = "fk_ID_музыкальной_группы"))
    private MusicGroup musicGroup;

    public PerformsGroup() {
    }

    public PerformsGroup(Integer id, Song song, MusicGroup musicGroup) {
        this.id = id;
        this.song = song;
        this.musicGroup = musicGroup;
    }

    public Integer getId() {
        return id;
    }
    public Song getSong() {
        return song;
    }
    public MusicGroup getMusicGroup() {
        return musicGroup;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setSong(Song song) {
        this.song = song;
    }
    public void setMusicGroup(MusicGroup musicGroup) {
        this.musicGroup = musicGroup;
    }
}

