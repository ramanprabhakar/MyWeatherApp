package com.ramanprabhakar.myweatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Raman on 4/13/2016.
 */
public class Temperature implements Serializable {
    @SerializedName("morn")
    double morn;

    @SerializedName("day")
    double day;

    @SerializedName("eve")
    double eve;

    @SerializedName("night")
    double night;

    @SerializedName("min")
    double min;

    @SerializedName("max")
    double max;

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}

