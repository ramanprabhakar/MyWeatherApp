package com.ramanprabhakar.myweatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Raman on 4/13/2016.
 */
public class City implements Serializable {
    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;

    @SerializedName("coord")
    Coord coord;

    @SerializedName("country")
    String country;

    @SerializedName("population")
    int population;

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

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
