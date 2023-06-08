package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "performsartist")
public class PerformsArtist {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_performsartist")
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_id_song", referencedColumnName = "id_song", foreignKey = @ForeignKey(name = "fk_id_song"))
    private Song song;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_id_artist", referencedColumnName = "id_artist", foreignKey = @ForeignKey(name = "fk_id_artist"))
    private Artist artist;

    public PerformsArtist() {
    }
    public PerformsArtist(Long id, Song song, Artist artist) {
        this.id = id;
        this.song = song;
        this.artist = artist;
    }
    public PerformsArtist(Song song, Artist artist) {
        this.song = song;
        this.artist = artist;
    }
}

