package com.example.spotify_encore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class reccomendationAdapter extends BaseAdapter {

    private List<String> recommendedTracks;
    private Context context;

    public reccomendationAdapter(List<String> recommendedTracks, Context context) {
        this.recommendedTracks = recommendedTracks;
        this.context = context;
    }

    public void setRecommendedTracks(List<String> recommendedTracks) {
        this.recommendedTracks = recommendedTracks;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return recommendedTracks.size();
    }

    @Override
    public Object getItem(int position) {
        return recommendedTracks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(recommendedTracks.get(position));

        return convertView;
    }
}