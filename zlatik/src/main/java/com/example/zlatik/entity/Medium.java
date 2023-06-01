package com.example.zlatik.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Носитель")
public class Medium {
    @Id
    @Column(name = "ID_носителя")
    private Integer id;

    @Column(name = "Тип_носителя")
    private String type;

    @Column(name = "Издатель")
    private String publisher;

    public Medium() {
    }

    public Medium(Integer id, String type, String publisher) {
        this.id = id;
        this.type = type;
        this.publisher = publisher;
    }

    public Integer getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

