package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Join;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "artist")
public class Artist {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_artist")
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT", name = "artist_name")
    private String artistName;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.REMOVE)
    private List<ContainsArtist> containsArtists;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.REMOVE)
    private List<PerformsArtist> performsArtists;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.REMOVE)
    private List<Joining> joinings;
    public Artist() {
    }
    public Artist(Long id, String artistName) {
        this.id = id;
        this.artistName = artistName;
    }

    public Artist(String artistName) {
        this.artistName = artistName;
    }
}

