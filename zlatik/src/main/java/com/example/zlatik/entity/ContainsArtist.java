package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "containsartist")
public class ContainsArtist {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_containsartist")
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_id_album", referencedColumnName = "id_album", foreignKey = @ForeignKey(name = "fk_id_album"))
    private Album album;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_id_artist", referencedColumnName = "id_artist", foreignKey = @ForeignKey(name = "fk_id_artist"))
    private Artist artist;
    public ContainsArtist() {
    }
    public ContainsArtist(Long id, Album album, Artist artist) {
        this.id = id;
        this.album = album;
        this.artist = artist;
    }
    public ContainsArtist(Album album, Artist artist) {
        this.album = album;
        this.artist = artist;
    }
}
