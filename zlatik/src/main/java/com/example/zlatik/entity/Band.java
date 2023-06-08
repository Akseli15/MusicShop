package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "band")
public class Band {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_band")
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT", name = "band_name")
    private String bandName;
    @OneToMany(mappedBy = "band", cascade = CascadeType.REMOVE)
    private List<ContainsBand> containsBands;
    @OneToMany(mappedBy = "band", cascade = CascadeType.REMOVE)
    private List<PerformsBand> performsBands;
    @OneToMany(mappedBy = "band", cascade = CascadeType.REMOVE)
    private List<Joining> joinings;

    public Band() {
    }
    public Band(Long id, String bandName) {
        this.id = id;
        this.bandName = bandName;
    }
    public Band(String bandName) {
        this.bandName = bandName;
    }
}

