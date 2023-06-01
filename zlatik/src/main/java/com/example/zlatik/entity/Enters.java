package com.example.zlatik.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Вступает")
public class Enters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_вступает")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_ID_музыкальной_группы", referencedColumnName = "Название", foreignKey = @ForeignKey(name = "fk_ID_музыкальной_группы"))
    private MusicGroup musicGroup;

    @ManyToOne
    @JoinColumn(name = "fk_ID_исполнителя", referencedColumnName = "ФИО", foreignKey = @ForeignKey(name = "fk_ID_исполнителя"))
    private Artist artist;

    @Column(name = "Дата_вступления")
    private Date entryDate;

    @Column(name = "Дата_ухода")
    private Date departureDate;

    public Enters() {
    }

    public Enters(MusicGroup musicGroup, Artist artist, Date entryDate, Date departureDate) {
        this.musicGroup = musicGroup;
        this.artist = artist;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
    }

    public Integer getId() {
        return id;
    }
    public MusicGroup getMusicGroup() {
        return musicGroup;
    }
    public Artist getArtist() {
        return artist;
    }
    public Date getEntryDate() {
        return entryDate;
    }
    public Date getDepartureDate() {
        return departureDate;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setMusicGroup(MusicGroup musicGroup) {
        this.musicGroup = musicGroup;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
}

