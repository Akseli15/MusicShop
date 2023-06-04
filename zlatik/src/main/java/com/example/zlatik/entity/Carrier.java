package com.example.zlatik.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "carrier")
public class Carrier {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL", name = "id_carrier")
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT", name = "carrier_type")
    private String carrierType;
    @Column(columnDefinition = "TEXT", name = "carrier_publisher")
    private String carrierPublisher;
    public Carrier() {
    }
    public Carrier(Long id, String carrierType, String carrierPublisher) {
        this.id = id;
        this.carrierType = carrierType;
        this.carrierPublisher = carrierPublisher;
    }
    public Carrier(String carrierType, String carrierPublisher) {
        this.carrierType = carrierType;
        this.carrierPublisher = carrierPublisher;
    }
}

