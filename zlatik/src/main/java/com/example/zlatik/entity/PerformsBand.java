package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "performsband")
public class PerformsBand {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_performsband")
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL",name = "fk_id_band", referencedColumnName = "id_band", foreignKey = @ForeignKey(name = "fk_id_band"))
    private Band band;

    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL",name = "fk_id_song", referencedColumnName = "id_song", foreignKey = @ForeignKey(name = "fk_id_song"))
    private Song song;
    public PerformsBand() {
    }
    public PerformsBand(Long id, Band band, Song song) {
        this.id = id;
        this.band = band;
        this.song = song;
    }
    public PerformsBand(Band band, Song song) {
        this.band = band;
        this.song = song;
    }
}

