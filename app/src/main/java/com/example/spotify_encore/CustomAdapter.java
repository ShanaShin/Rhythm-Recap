package com.example.spotify_encore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[][] data;

    public CustomAdapter(Context context, String[][] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public String[][] getData() {
        return data;
    }


    @Override
    public int getCount() {
        // Total number of items in the 2x5 matrix
        return Math.min(2, data.length) * data[0].length;
    }

    @Override
    public Object getItem(int position) {
        int row = position / data[0].length; // Calculate row index
        if (row >= 2) {
            // If the row index is 2 or greater, return null to indicate it's beyond the data bounds
            return null;
        }
        int col = position % data[0].length; // Calculate column index
        return data[row][col];
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position / data[0].length > 0) {
            // If the row index is greater than 0, return an empty view
            return new View(context);
        }
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null);
        }

        int row = position / data[0].length; // Calculate row index
        int col = position % data[0].length; // Calculate column index

        TextView textView1 = view.findViewById(R.id.textView1);
        TextView textView2 = view.findViewById(R.id.textView2);

        // Set data to TextViews
        if (row == 0) {
            // If it's the first row, set data to textView1
            textView1.setText(data[row][col]);
            if (row + 1 < data.length) {
                textView2.setText(data[row + 1][col]);
            } else {
                textView2.setText(""); // Set an empty string if there's no data in the second row
            }
        }

        return view;
    }
}