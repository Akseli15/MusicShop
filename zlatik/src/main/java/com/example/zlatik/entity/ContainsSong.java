package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "containssong")
public class ContainsSong {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_join")
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_id_album", referencedColumnName = "id_album", foreignKey = @ForeignKey(name = "fk_id_album"))
    private Album album;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_id_song", referencedColumnName = "id_song", foreignKey = @ForeignKey(name = "fk_id_song"))
    private Song song;
    @Column(name = "indexnumber")
    private Integer indexNumber;

    public ContainsSong() {
    }
    public ContainsSong(Long id, Album album, Song song, Integer indexNumber) {
        this.id = id;
        this.album = album;
        this.song = song;
        this.indexNumber = indexNumber;
    }
    public ContainsSong(Album album, Song song, Integer indexNumber) {
        this.album = album;
        this.song = song;
        this.indexNumber = indexNumber;
    }
}

