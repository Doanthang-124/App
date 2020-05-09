package com.example.appweather1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class customAdapter extends ArrayAdapter<thoitiet> {

    Activity context;
    int resource;
    List<thoitiet> objects;
    public customAdapter(@NonNull Activity context, int resource, @NonNull List<thoitiet> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);
        TextView txtNgay=(TextView) row.findViewById(R.id.txtNgay);
        TextView txtTrangThai=(TextView) row.findViewById(R.id.txtTrangThai);
        ImageView imgTrangThai=(ImageView) row.findViewById(R.id.imgTrangThai);
        TextView txtMaxTemp=(TextView) row.findViewById(R.id.txtMaxTemp);
        TextView txtMinTemp=(TextView) row.findViewById(R.id.txtMinTemp);
        // trả về danh bạ muốn về
        thoitiet Thoitiet=this.objects.get(position);
        txtNgay.setText(Thoitiet.getDay());
        txtTrangThai.setText(Thoitiet.getStatus());
        txtMaxTemp.setText(Thoitiet.getMaxTemp());
        txtMinTemp.setText(Thoitiet.getMinTemp());
        txtTrangThai.setText(Thoitiet.getImage());

        return row;
    }
}
