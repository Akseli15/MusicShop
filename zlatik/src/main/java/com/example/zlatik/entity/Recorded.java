package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recorded")
public class Recorded {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_recorded")
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL", name = "fk_id_album", referencedColumnName = "id_album", foreignKey = @ForeignKey(name = "fk_id_album"))
    private Album album;

    @ManyToOne
    @JoinColumn(columnDefinition = "BIGSERIAL",name = "fk_id_carrier", referencedColumnName = "id_carrier", foreignKey = @ForeignKey(name = "fk_id_carrier"))
    private Carrier carrier;

    @Column(columnDefinition = "TEXT", name = "recorded_cost")
    private Integer recordedCost;
    public Recorded() {
    }
    public Recorded(Long id, Album album, Carrier carrier, Integer recordedCost) {
        this.id = id;
        this.album = album;
        this.carrier = carrier;
        this.recordedCost = recordedCost;
    }
    public Recorded(Album album, Carrier carrier, Integer recordedCost) {
        this.album = album;
        this.carrier = carrier;
        this.recordedCost = recordedCost;
    }
}


