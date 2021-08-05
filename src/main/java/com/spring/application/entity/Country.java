package com.spring.application.entity;

public class Country {
    private String country;
    private int gold;
    private int silver;
    private int bronze;

    public Country(String country, int gold, int silver, int bronze) {
        this.country = country;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
    private void add(int gold,int silver,int bronze){
        this.gold=gold;
        this.silver=silver;
        this.bronze=bronze;
    }


    public void add(Country prev) {
        this.gold+= prev.gold;
        this.silver+=prev.silver;
        this.bronze+=prev.bronze;

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
