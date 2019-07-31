package com.example.prototype1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    private CardView fertilizer, pesticides, weather, community;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        fertilizer = (CardView) findViewById(R.id.fertilizer);
        pesticides = (CardView) findViewById(R.id.pest);
        weather = (CardView) findViewById(R.id.weather);
        community = (CardView) findViewById(R.id.comm);

        fertilizer.setOnClickListener(this);
        pesticides.setOnClickListener(this);
        weather.setOnClickListener(this);
        community.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        Intent i;

        switch (view.getId()) {
            case R.id.fertilizer:
                i = new Intent(this, Fertilizer.class);
                startActivity(i);
                break;
            case R.id.pest:
                i = new Intent(this, Pesticide.class);
                startActivity(i);
                break;
            case R.id.weather:
                i = new Intent(this, Weather.class);
                startActivity(i);
                break;
            case R.id.comm:
                i = new Intent(this, Community.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
