package com.example.appweather1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {
    String tenThanhPho="";
    ImageView imgBack;
    TextView txtTenThanhPho;

    ListView lvDanhSach;
    ArrayList<thoitiet> dsthoitiet;
    customAdapter CustomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addControls();
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String city= intent.getStringExtra("name");
        Log.d("ketqua","Du lieu truyen qua:"+city);
        if(city.equals(""))
        {
            tenThanhPho="SaiGon";
            Getdata7day(tenThanhPho);
        }
        else
        {
            tenThanhPho=city;
            Getdata7day(tenThanhPho);
        }
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void addControls() {
        txtTenThanhPho=(TextView) findViewById(R.id.txtThanhPho);
        imgBack=(ImageView) findViewById(R.id.imgBack);
        dsthoitiet=new ArrayList<>();
        CustomAdapter=new customAdapter(Main2Activity.this,R.layout.dong_listview,dsthoitiet);
        lvDanhSach=(ListView) findViewById(R.id.lvDanhSach);
        lvDanhSach.setAdapter(CustomAdapter);

    }

    private void Getdata7day(String data) {
        String  url="https://api.openweathermap.org/data/2.5/weather?q="+data+"&units=metric&appid=53a42feed9423bcff4067dfb17e6facb";
        RequestQueue requestQueue= Volley.newRequestQueue(Main2Activity.this);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONObject jsonObjectcity=jsonObject.getJSONObject("city");
                            String name=jsonObjectcity.getString("name");
                            txtTenThanhPho.setText("name");

                            JSONArray jsonArrayList=jsonObject.getJSONArray("list");
                            for(int i=0;i<jsonArrayList.length();i++)
                            {
                                JSONObject jsonObjectList=jsonArrayList.getJSONObject(i);
                                String ngay=jsonObjectList.getString("dt");
                                long l=Long.valueOf(ngay);
                                Date date=new Date(l*1000L);
                                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("EEEE dd-MM-yyyy ");
                                String Day=simpleDateFormat.format(date);

                                JSONObject jsonObjectTemp=jsonObjectList.getJSONObject("temp");
                                String Max=jsonObjectTemp.getString("max");
                                String Min=jsonObjectTemp.getString("min");
                                Double a=Double.valueOf(Max);
                                String Nhietdomax= String.valueOf(a.intValue());
                                Double b=Double.valueOf(Min);
                                String Nhietdomin= String.valueOf(a.intValue());

                                JSONArray jsonArrayweather=jsonObjectList.getJSONArray("weather");
                                JSONObject jsonObjectweather=jsonArrayweather.getJSONObject(0);
                                String status=jsonObjectweather.getString("description");
                                String icon=jsonObjectweather.getString("icon");
                                dsthoitiet.add(new thoitiet(Day,status,icon,Nhietdomax,Nhietdomin));
                            }
                            CustomAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(stringRequest);
    }
}
