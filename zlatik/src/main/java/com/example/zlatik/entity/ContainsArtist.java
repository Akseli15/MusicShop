package com.example.zlatik.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Содержит_исполнитель")
public class ContainsArtist {
    @Id
    @Column(name = "ID_содержит_исполнитель")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_ID_альбома", referencedColumnName = "ID_название_альбома", foreignKey = @ForeignKey(name = "fk_ID_альбома"))
    private Album album;

    @ManyToOne
    @JoinColumn(name = "fk_ID_исполнителя", referencedColumnName = "ФИО", foreignKey = @ForeignKey(name = "fk_ID_исполнителя"))
    private Artist artist;

    public ContainsArtist() {
    }

    public ContainsArtist(Integer id, Album album, Artist artist) {
        this.id = id;
        this.album = album;
        this.artist = artist;
    }

    public Integer getId() {
        return id;
    }
    public Album getAlbum() {
        return album;
    }
    public Artist getArtist() {
        return artist;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setAlbum(Album album) {
        this.album = album;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
