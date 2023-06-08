package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "joining")
public class Joining {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_joining")
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_id_band", referencedColumnName = "id_band", foreignKey = @ForeignKey(name = "fk_id_band"))
    private Band band;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_id_artist", referencedColumnName = "id_artist", foreignKey = @ForeignKey(name = "fk_id_artist"))
    private Artist artist;
    @JoinColumn(name = "join_date")
    private LocalDate joinDate;
    @JoinColumn(name = "leave_date")
    private LocalDate leaveDate;
    public Joining() {
    }
    public Joining(Long id, Band band, Artist artist, LocalDate joinDate, LocalDate leaveDate) {
        this.id = id;
        this.band = band;
        this.artist = artist;
        this.joinDate = joinDate;
        this.leaveDate = leaveDate;
    }
    public Joining(Band band, Artist artist, LocalDate joinDate, LocalDate leaveDate) {
        this.band = band;
        this.artist = artist;
        this.joinDate = joinDate;
        this.leaveDate = leaveDate;
    }
    public String getArtistName() {
        if (artist != null) {
            return artist.getArtistName();
        }
        return null;
    }

    public String getBandName() {
        if (band != null) {
            return band.getBandName();
        }
        return null;
    }
}

