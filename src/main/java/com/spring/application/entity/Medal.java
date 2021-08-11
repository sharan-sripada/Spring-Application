package com.spring.application.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "medal")
public class Medal {



    @Id
    @Column(name = "id")
    @NotNull(message = "Enter a number")
    public  int id;

    @OneToOne()
    @PrimaryKeyJoinColumn()
    private Athlete athlete;

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    @NotNull(message = "Enter a number")
    @Column(name="gold")
    private int gold;


    @NotNull(message = "Enter a number")
    @Column(name="silver")
    private int silver;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull(message = "Enter a number")
    @Column(name="bronze")
    private int bronze;



    public Medal() {
    }

    public Medal( int id,int gold, int silver, int bronze) {
        this.id=id;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }




    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }
}
