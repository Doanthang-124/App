package com.example.appweather1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText txtTen;
    Button btnChon,btnChange;
    TextView txtQuocGia,txtThanhPho,txtDay,txtNhietDo,txtTrangThai,txtDoAm,txtSucGio,txtCloud;
    ImageView imgIcon;
    String City="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        GetCurrentWeatherData("SaiGon");
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city=txtTen.getText().toString();
                if(city.equals(""))
                {
                    City="SaiGon";
                    GetCurrentWeatherData(City);
                }
                else
                {
                    City=city;
                    GetCurrentWeatherData(City);
                }

            }
        });
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city=txtTen.getText().toString();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("name",city);
                startActivity(intent);
            }
        });
    }
    public void GetCurrentWeatherData(String data)
    {
        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
        String url="https://api.openweathermap.org/data/2.5/weather?q="+data+"&units=metric&appid=53a42feed9423bcff4067dfb17e6facb";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String day=jsonObject.getString("dt");
                            String name=jsonObject.getString("name");
                            txtThanhPho.setText("Tên Thành Phố: "+name);

                            long l=Long.valueOf(day);
                            Date date=new Date(l*1000L);
                            SimpleDateFormat simpleDateFormat= new SimpleDateFormat("EEEE dd-MM-yyyy HH-mm-ss");
                            String Day=simpleDateFormat.format(date);
                            txtDay.setText(Day);

                            JSONArray jsonArrayweather=jsonObject.getJSONArray("weather");
                            JSONObject jsonObjectweather=jsonArrayweather.getJSONObject(0);
                            String  status=jsonObjectweather.getString("main");
                            String icon=jsonObjectweather.getString("icon");
                            Picasso.with(MainActivity.this).load("http://openweathermap.org/img/wn/"+icon+"@2x.png").into(imgIcon);
                            txtTrangThai.setText(status);

                            JSONObject jsonObjectMain=jsonObject.getJSONObject("main");
                            String nhietdo=jsonObjectMain.getString("temp");
                            String doam=jsonObjectMain.getString("humidity");

                            Double a=Double.valueOf(nhietdo);
                            String Nhietdo= String.valueOf(a.intValue());
                            txtNhietDo.setText(Nhietdo+"°C ");
                            txtDoAm.setText(doam+"%");

                            JSONObject jsonObjectwind=jsonObject.getJSONObject("wind");
                            String gio=jsonObjectwind.getString("speed");
                            txtSucGio.setText(gio+"m/s");

                            JSONObject jsonObjectclouds=jsonObject.getJSONObject("clouds");
                            String may=jsonObjectclouds.getString("all");
                            txtCloud.setText(may+"%");

                            JSONObject jsonObjectsys=jsonObject.getJSONObject("sys");
                            String Country=jsonObjectsys.getString("country");
                            txtQuocGia.setText("Tên quốc gia:"+Country);
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

    private void addControls() {
        txtTen = (EditText) findViewById(R.id.txtTen);
        btnChon=(Button) findViewById(R.id.btnChon);
        btnChange=(Button) findViewById(R.id.btnChange);
        txtQuocGia=(TextView) findViewById(R.id.txtQuocGia);
        txtThanhPho=(TextView) findViewById(R.id.txtThanhPho);
        txtDay=(TextView) findViewById(R.id.txtDay);
        txtNhietDo=(TextView) findViewById(R.id.txtNhietDo);
        txtTrangThai=(TextView) findViewById(R.id.txtTrangThai);
        txtDoAm=(TextView) findViewById(R.id.txtDoAm);
        txtSucGio=(TextView) findViewById(R.id.txtSucGio);
        txtCloud=(TextView) findViewById(R.id.txtCloud);
        imgIcon=(ImageView) findViewById(R.id.imgIcon);

    }
}
