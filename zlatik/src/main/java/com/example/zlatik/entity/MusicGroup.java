package com.example.zlatik.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Музыкальная_группа")
public class MusicGroup {
    @Id
    @Column(name = "Название")
    private String name;

    public MusicGroup() {
    }
    public MusicGroup(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

