package com.ramanprabhakar.myweatherapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ramanprabhakar.myweatherapp.AppConstants;
import com.ramanprabhakar.myweatherapp.ForecastRecyclerViewAdapter;
import com.ramanprabhakar.myweatherapp.R;
import com.ramanprabhakar.myweatherapp.WeatherService;
import com.ramanprabhakar.myweatherapp.model.WeatherResponse;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {
    String url = "http://api.openweathermap.org";
    RecyclerView recyclerView;
    ForecastRecyclerViewAdapter mAdapter;
    WeatherService weatherService;
    String location;
    String dayCount = "7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        getReport();
    }

    private void getReport() {

        OkHttpClient okHttpClient = new OkHttpClient();
        OkClient okClient = new OkClient(okHttpClient);

        Cache cache = new Cache(this.getCacheDir(), 1024);
        okHttpClient.setCache(cache);

        RestAdapter jsonRestAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog("Retrofit"))
                .setEndpoint(url)
                .setClient(okClient)
                .build();

        weatherService = jsonRestAdapter.create(WeatherService.class);

        weatherService.getWeather(AppConstants.DEFAULT_LOCATION, dayCount, new Callback<WeatherResponse>() {
            @Override
            public void success(WeatherResponse weatherResponse, Response response) {

                String city = weatherResponse.getCity().getName();
                TextView cityNameTV = (TextView) findViewById(R.id.tv_main);
                if (cityNameTV != null) {
                    cityNameTV.setText(city);
                }
                populateList(weatherResponse);

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }

    private void populateList(WeatherResponse weatherResponse) {
        if (!weatherResponse.getList().isEmpty()) {
            mAdapter = new ForecastRecyclerViewAdapter(this, weatherResponse.getList());
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView = (RecyclerView) findViewById(R.id.rv_forecast);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(mAdapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        if (id == R.id.action_refresh) {
            getReport();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
