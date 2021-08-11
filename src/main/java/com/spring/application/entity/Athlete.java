package com.spring.application.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "athlete")
public class Athlete {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name="name")
    @NotNull(message = "Name age cannot be null.")
    @NotEmpty(message = "Country age cannot be null.")
    private String name;


    @Column(name="country")
    @NotNull(message = "Country age cannot be null.")
    @NotEmpty(message = "Country age cannot be null.")

    private String country;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private int weight;

    @OneToOne(mappedBy="athlete")
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
    public Athlete( String name, String country,int height, int weight) {
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

    public Medal getMedal() {
        return medal;
    }

    public void setMedal(Medal medal) {
        this.medal = medal;
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
