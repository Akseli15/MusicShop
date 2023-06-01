package com.example.zlatik.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Жанр")
public class Genre {
    @Id
    @Column(name = "Название_жанра")
    private String name;

    public Genre() {
    }
    public Genre(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

