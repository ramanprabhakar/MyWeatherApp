package com.ramanprabhakar.myweatherapp;

import android.content.Context;

import com.ramanprabhakar.myweatherapp.model.WeatherResponse;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;

/**
 * Created by Raman on 5/18/2016.
 */
public class HttpService {

    private static HttpService instance = new HttpService();
    private Context context;

    private WeatherService weatherService;

    private HttpService() {
    }

    public void setUp(Context context) {
        this.context = context;

        OkHttpClient okHttpClient = new OkHttpClient();
        OkClient okClient = new OkClient(okHttpClient);

        Cache cache = new Cache(context.getCacheDir(), 1024);
        okHttpClient.setCache(cache);

        RestAdapter jsonRestAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog("Retrofit"))
                .setEndpoint(AppConstants.BASE_URL)
                .setClient(okClient)
                .build();

        weatherService = jsonRestAdapter.create(WeatherService.class);
    }

    public static HttpService getInstance() {
        return instance;
    }

    public void getWeather(String location, String dayCount, Callback<WeatherResponse> callback) {
        weatherService.getWeather(location, dayCount, callback);
    }
}
