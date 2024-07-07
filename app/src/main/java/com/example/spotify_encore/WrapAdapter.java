package com.example.spotify_encore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class WrapAdapter extends ArrayAdapter<Wrap> {

    public WrapAdapter(Context context, ArrayList<Wrap> wraps) {
        super(context, 0, wraps);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Wrap wrap = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_wrap, parent, false);
        }
        TextView textView = convertView.findViewById(R.id.text_view_wrap);

        return convertView;
    }
}