package com.example.zlatik.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Содержит_носитель")
public class ContainsMedium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_cодержит_носитель")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_ID_альбома", referencedColumnName = "ID_название_альбома", foreignKey = @ForeignKey(name = "fk_ID_альбома"))
    private Album album;

    @ManyToOne
    @JoinColumn(name = "fk_ID_носителя", referencedColumnName = "ID_носителя", foreignKey = @ForeignKey(name = "fk_ID_носителя"))
    private Medium medium;

    @Column(name = "Стоимость")
    private Integer cost;

    public ContainsMedium() {
    }

    public ContainsMedium(Album album, Medium medium, Integer cost) {
        this.album = album;
        this.medium = medium;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }
    public Album getAlbum() {
        return album;
    }
    public Medium getMedium() {
        return medium;
    }
    public Integer getCost() {
        return cost;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setAlbum(Album album) {
        this.album = album;
    }
    public void setMedium(Medium medium) {
        this.medium = medium;
    }
    public void setCost(Integer cost) {
        this.cost = cost;
    }
}


