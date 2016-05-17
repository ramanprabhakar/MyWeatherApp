package com.ramanprabhakar.myweatherapp;

import com.ramanprabhakar.myweatherapp.model.WeatherResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;


/**
 * Created by Raman on 4/13/2016.
 */
public interface WeatherService {

    @GET("/data/2.5/forecast/daily?mode=json&units=metric&appid=c6c69047c622fc3067a2755bbb8a3b71")
//    @GET("/data/2.5/forecast/daily?q=delhi&mode=json&units=metric&cnt=14&appid=c6c69047c622fc3067a2755bbb8a3b71")
    void  getWeather(@Query("q") String location,@Query("cnt") String dayCount, Callback<WeatherResponse> callback);
}
