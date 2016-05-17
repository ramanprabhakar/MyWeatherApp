package com.ramanprabhakar.myweatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Raman on 4/13/2016.
 */
public class DayWeather implements Serializable {
    @SerializedName("dt")
    long dt;

    @SerializedName("temp")
    Temperature temp;


    @SerializedName("pressure")
    double pressure;


    @SerializedName("humidity")
    int humidity;


    @SerializedName("weather")
    ArrayList<WeatherDetails> weather = new ArrayList<>();


    @SerializedName("speed")
    Double speed;


    @SerializedName("deg")
    int deg;


    @SerializedName("clouds")
    int clouds;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public ArrayList<WeatherDetails> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<WeatherDetails> weather) {
        this.weather = weather;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }
}
