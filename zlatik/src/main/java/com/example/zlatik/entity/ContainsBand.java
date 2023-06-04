package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "containsband")
public class ContainsBand {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_containsband")
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_id_album", referencedColumnName = "id_album", foreignKey = @ForeignKey(name = "fk_id_album"))
    private Album album;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_id_band", referencedColumnName = "id_band", foreignKey = @ForeignKey(name = "fk_id_band"))
    private Band band;

    public ContainsBand() {
    }
    public ContainsBand(Long id, Album album, Band band) {
        this.id = id;
        this.album = album;
        this.band = band;
    }
    public ContainsBand(Album album, Band band) {
        this.album = album;
        this.band = band;
    }
}

