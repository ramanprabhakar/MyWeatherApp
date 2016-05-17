package com.ramanprabhakar.myweatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Raman on 4/13/2016.
 */
public class WeatherResponse implements Serializable {
    @SerializedName("city")
    City city;

    @SerializedName("cod")
    String cod;

    @SerializedName("message")
    Double message;

    @SerializedName("cnt")
    int cnt;

    @SerializedName("list")
    ArrayList<DayWeather> list = new ArrayList<>();

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ArrayList<DayWeather> getList() {
        return list;
    }

    public void setList(ArrayList<DayWeather> list) {
        this.list = list;
    }
}
