package com.example.prototype1;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class English extends AppCompatActivity  {

    private ViewPager nSlideViewPager;
    private LinearLayout nLayout;

    private SliderAdapter sliderAdapter;

    private TextView[] dots;
    private Button upload;
    private ImageButton right_button;
    private ImageButton left_button;
    private int nCurrent;
    private int i;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

        nSlideViewPager = (ViewPager) findViewById(R.id.slider);
        /*nLayout = (LinearLayout) findViewById(R.id.layout);*/
        upload =  findViewById(R.id.button6);
        right_button = (ImageButton) findViewById(R.id.button3);
        left_button = (ImageButton) findViewById(R.id.button2);
       /* Intent intent=getIntent();*/
        i=getIntent().getIntExtra("v",0);


        sliderAdapter = new SliderAdapter(this);
        nSlideViewPager.setAdapter(sliderAdapter);
        if(i==0){
        sliderAdapter.decide();}
        if(i==1){
        sliderAdapter.decide1();}
        if(i==2){
            sliderAdapter.decide2();}
        if(i==3){
            sliderAdapter.decide3();}
        dot_indicator(0);
        nSlideViewPager.addOnPageChangeListener(viewListener);

        /*Intent intent=getIntent();
        int num=intent.getIntExtra("val",0);

        Intent intent1=new Intent(English.this,SliderAdapter.class);
        intent1.putExtra("valp",num);
        startActivity(intent1);*/



        right_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nSlideViewPager.setCurrentItem(nCurrent + 1);
            }
        });
        left_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nSlideViewPager.setCurrentItem(nCurrent - 1);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int current=getItem(1);
                if(current==1) {


                    launch_fertilizer();
                }
                if(current==2){
                    launch_pesticide();
                }
                if(current==3){
                    launch_weather();
                }
                if(current==4)
                {
                    launch_community();
                }
                if(current==5){
                    launch_dash();
                }



            }
        });


    }


    public void dot_indicator(int position) {

        dots = new TextView[3];
        /*nLayout.removeAllViews();*/

        for (int i = 0; i < dots.length; i++) {

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.silver));
            /*nLayout.addView(dots[i]);*/

        }
        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.black));
        }
    }

    ViewPager.OnPageChangeListener viewListener;

    public int page(int i) {
        int page_num = i;
        return 0;
    }

    {
        viewListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int i) {
                dot_indicator(i);
                nCurrent = i;


                if (i == 0) {

                    right_button.setEnabled(true);
                    left_button.setEnabled(false);
                    left_button.setVisibility(View.INVISIBLE);
                    right_button.setImageResource(R.drawable.right_arrow);


                } else if (i == dots.length - 1) {

                    right_button.setEnabled(true);
                    left_button.setEnabled(true);
                    left_button.setVisibility(View.VISIBLE);
                    right_button.setImageResource(R.drawable.image);
                    left_button.setImageResource(R.drawable.left_arrow);
                    right_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            launch_dash();
                        }

                    });

                } else {

                    right_button.setEnabled(true);
                    left_button.setEnabled(true);
                    left_button.setVisibility(View.VISIBLE);
                    right_button.setImageResource(R.drawable.right_arrow);
                    left_button.setImageResource(R.drawable.left_arrow);
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    private int getItem(int i) {
        return nSlideViewPager.getCurrentItem() + i;
    }




    private void launch_fertilizer() {

        startActivity(new Intent(this, Fertilizer.class));
        finish();
    }

   private void launch_weather() {
        startActivity(new Intent(this, Weather.class));
        finish();
    }

    private void launch_pesticide() {
        startActivity(new Intent(this, Pesticide.class));
        finish();
    }
    private void launch_community() {
        startActivity(new Intent(this, Community.class));
        finish();
    }
    private void launch_dash() {
        startActivity(new Intent(this, Dashboard.class));
        finish();
    }



}





