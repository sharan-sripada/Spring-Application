package com.spring.application.entity;

import javax.persistence.*;

@Entity
@Table(name = "athlete")
public class Athlete {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private int weight;

    @OneToOne(mappedBy="athlete",
            cascade=CascadeType.ALL)
    private Medal medal;

    public Athlete() {
    }

    public Athlete(int id, String name, String country,int height, int weight) {
        this.id = id;
        this.name = name;
        this.country=country;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
