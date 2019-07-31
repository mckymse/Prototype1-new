package com.example.prototype1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.content.Intent;


import com.tomer.fadingtextview.FadingTextView;

import java.util.Locale;

public class Language extends AppCompatActivity implements View.OnClickListener {

    private CardView hindi,tamil,english,telugu;

    private FadingTextView fadingTextView;
    private int j;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language);
        loadLocale();



        fadingTextView = findViewById(R.id.fade);
        hindi = (CardView) findViewById(R.id.hindi);
        tamil = (CardView) findViewById(R.id.tamil);
        english = (CardView) findViewById(R.id.english);
        telugu = (CardView) findViewById(R.id.telugu);

        hindi.setOnClickListener(this);
        tamil.setOnClickListener(this);
        english.setOnClickListener(this);
        telugu.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        Intent i;



        if(view.getId()==R.id.tamil)
        {setLocale("ta");recreate();}
        if(view.getId()==R.id.hindi)
        {setLocale("hi");recreate();}
        if(view.getId()==R.id.telugu)
        {setLocale("te");recreate();}
        if(view.getId()==R.id.english)
        {setLocale("en");recreate();}

        switch (view.getId()){
            case R.id.hindi : i = new Intent(Language.this,English.class);i.putExtra("v",2);startActivity(i);break;
            case R.id.english : i = new Intent(Language.this,English.class);i.putExtra("v",0);startActivity(i);break;
            case R.id.tamil : i = new Intent(Language.this,English.class);i.putExtra("v",1);startActivity(i);break;
            case R.id.telugu : i = new Intent(Language.this,English.class);i.putExtra("v",3);startActivity(i);break;
            default:break;
        }

        /*if(view.getId()==R.id.tamil){ j=0;}
        Intent intent=new Intent(Language.this,English.class);
        intent.putExtra("Val",j);
        startActivity(intent);*/
    }

    private void setLocale(String lang){
        Locale locale= new Locale(lang);
        Locale.setDefault(locale);
        Configuration config=new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor= getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("MY_LANG",lang);
        editor.apply();

    }
    public void loadLocale(){
        SharedPreferences prefs=getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("MY_LANG","");
        setLocale(language);
    }
}
