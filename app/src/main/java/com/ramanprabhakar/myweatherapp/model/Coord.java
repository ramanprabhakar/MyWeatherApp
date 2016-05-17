package com.ramanprabhakar.myweatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Raman on 4/13/2016.
 */
public class Coord implements Serializable {

    @SerializedName("lon")
    double lon;

    @SerializedName("lat")
    double lat;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
