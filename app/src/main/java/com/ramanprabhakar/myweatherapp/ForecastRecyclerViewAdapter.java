package com.ramanprabhakar.myweatherapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ramanprabhakar.myweatherapp.Activities.DetailsActivity;
import com.ramanprabhakar.myweatherapp.model.DayWeather;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Raman on 5/12/2016.
 */
public class ForecastRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    ArrayList<DayWeather> mList;

    public ForecastRecyclerViewAdapter(Context context, ArrayList<DayWeather> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item_forecast, parent, false);
        RowsViewHolder vh = new RowsViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        RowsViewHolder vh = (RowsViewHolder) holder;

        SimpleDateFormat date = new SimpleDateFormat("EEE, MMM dd");
        String dateString = date.format(mList.get(position).getDt());

        vh.tvListItem.setText(dateString + " - " + mList.get(position).getWeather().get(0).getMain() + " - " + (int)(mList.get(position).getTemp().getMax()) + "/" + (int)mList.get(position).getTemp().getMin());

        vh.recyclerListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(AppConstants.DAY_WEATHER,mList.get(position));
                Intent intent = new Intent(mContext,DetailsActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class RowsViewHolder extends RecyclerView.ViewHolder {
        TextView tvListItem;
        View recyclerListItem;
        public RowsViewHolder(View itemView) {
            super(itemView);
            recyclerListItem = itemView;
            tvListItem = (TextView) itemView.findViewById(R.id.tv_list_item);
        }
    }
}
