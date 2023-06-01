package com.example.zlatik.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Содержит_песня")
public class ContainsSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_cодержит_песня")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_ID_альбома", referencedColumnName = "ID_название_альбома", foreignKey = @ForeignKey(name = "fk_ID_альбома"))
    private Album album;

    @ManyToOne
    @JoinColumn(name = "fk_ID_песни", referencedColumnName = "Название_песни", foreignKey = @ForeignKey(name = "fk_ID_песни"))
    private Song song;

    @Column(name = "Порядковый_номер")
    private Integer trackNumber;

    public ContainsSong() {
    }

    public ContainsSong(Album album, Song song, Integer trackNumber) {
        this.album = album;
        this.song = song;
        this.trackNumber = trackNumber;
    }

    public Integer getId() {
        return id;
    }
    public Album getAlbum() {
        return album;
    }
    public Song getSong() {
        return song;
    }
    public Integer getTrackNumber() {
        return trackNumber;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setAlbum(Album album) {
        this.album = album;
    }
    public void setSong(Song song) {
        this.song = song;
    }
    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }
}

