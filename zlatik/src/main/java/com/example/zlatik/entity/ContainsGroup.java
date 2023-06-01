package com.example.zlatik.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Содержит_группа")
public class ContainsGroup {
    @Id
    @Column(name = "ID_cодержит_группа")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_ID_альбома", referencedColumnName = "ID_название_альбома", foreignKey = @ForeignKey(name = "fk_ID_альбома"))
    private Album album;

    @ManyToOne
    @JoinColumn(name = "fk_ID_музыкальной_группы", referencedColumnName = "Название", foreignKey = @ForeignKey(name = "fk_ID_музыкальной_группы"))
    private MusicGroup musicGroup;

    public ContainsGroup() {
    }

    public ContainsGroup(Integer id, Album album, MusicGroup musicGroup) {
        this.id = id;
        this.album = album;
        this.musicGroup = musicGroup;
    }

    public Integer getId() {
        return id;
    }
    public Album getAlbum() {
        return album;
    }
    public MusicGroup getMusicGroup() {
        return musicGroup;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setAlbum(Album album) {
        this.album = album;
    }
    public void setMusicGroup(MusicGroup musicGroup) {
        this.musicGroup = musicGroup;
    }
}

