package com.nvh.login_logup;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<CountriesModel> custListView;
    LayoutInflater layoutInflater;
    CountriesModel countriesModel;

    public CustomAdapter(Context context, ArrayList<CountriesModel> countriesData) {
        this.context = context;
        this.custListView = countriesData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return custListView.size();
    }

    @Override
    public Object getItem(int i) {
        return custListView.get(i);
    }

    @Override
    public long getItemId(int i) {
        return custListView.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View rowView = view;
        if (rowView==null) {
            rowView = layoutInflater.inflate(R.layout.row, null, true);
        }
        //link views
        ImageView imageView = rowView.findViewById(R.id.img);
        TextView countryNameTv = rowView.findViewById(R.id.text1);

        countriesModel = custListView.get(position);

        imageView.setImageResource(countriesModel.getImage());
        countryNameTv.setText(countriesModel.getName());

        return rowView;
    }





}
