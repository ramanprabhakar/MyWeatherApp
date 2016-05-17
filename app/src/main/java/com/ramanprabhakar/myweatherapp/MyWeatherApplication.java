package com.ramanprabhakar.myweatherapp;

import android.app.Application;

/**
 * Created by Raman on 5/18/2016.
 */
public class MyWeatherApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpService.getInstance().setUp(getApplicationContext());
    }
}
