package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
@Getter
@Setter
@Entity
@Table(name = "join")
public class Join {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_join")
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_id_band", referencedColumnName = "id_band", foreignKey = @ForeignKey(name = "fk_id_band"))
    private Band band;
    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_id_artist", referencedColumnName = "id_artist", foreignKey = @ForeignKey(name = "fk_id_artist"))
    private Artist artist;
    @JoinColumn(columnDefinition = "DATE",name = "joindate")
    private Date joinDate;
    @JoinColumn(columnDefinition = "DATE",name = "leavedate")
    private Date leaveDate;
    public Join() {
    }
    public Join(Long id, Band band, Artist artist, Date joinDate, Date leaveDate) {
        this.id = id;
        this.band = band;
        this.artist = artist;
        this.joinDate = joinDate;
        this.leaveDate = leaveDate;
    }

    public Join(Band band, Artist artist, Date joinDate, Date leaveDate) {
        this.band = band;
        this.artist = artist;
        this.joinDate = joinDate;
        this.leaveDate = leaveDate;
    }
}

