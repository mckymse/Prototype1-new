package com.example.prototype1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Math.ceil;

public class Fertilizer_result extends AppCompatActivity {

    TextView tv,tv1,tv2,tv3,tb,tb1,tb2,tr;
    int N=0,P=0,K=0;
    String crop;
    ImageView pic;
    /*String sugarcane = "sugarcane";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fertilizer_result);


        pic=findViewById(R.id.choose_pic);
        tv=(TextView) findViewById(R.id.display_corp);
        tv1=(TextView) findViewById(R.id.display_N2);
        tv2=(TextView) findViewById(R.id.display_P2);
        tv3=(TextView) findViewById(R.id.display_K2);

        tb=(TextView)findViewById(R.id.textView11);
        tb1=(TextView)findViewById(R.id.textView12);
        tb2=(TextView)findViewById(R.id.textView13);

        /*crop = tv.getText().toString();
        choose(crop);*/

        /*if(crop.equalsIgnoreCase("Sugarcane")){
            pic.setImageResource(R.drawable.sugar_cane);
        }
        if(crop.equalsIgnoreCase("cotton")){
            pic.setImageResource(R.drawable.cotton);
        }*/


        tr=findViewById(R.id.Amt);

        tv.setText(getIntent().getStringExtra("Name"));
        tv1.setText(String.valueOf(getIntent().getIntExtra("value1",0)));
        tv2.setText(String.valueOf(getIntent().getIntExtra("value2",0)));
        tv3.setText(String.valueOf(getIntent().getIntExtra("value3",0)));

        N=Integer.valueOf(tv1.getText().toString());
        P=Integer.valueOf(tv2.getText().toString());
        K=Integer.valueOf(tv3.getText().toString());

        double N1=ceil((2.17*N)/50);
        double P1=ceil((6.25*P)/50);
        double K1=ceil((1.66*K)/50);

        double N50=(N*2.17*5.31)+(P*6.25*6)+(K*12.4*1.66);


        tb.setText(String.valueOf(N1));
        tb1.setText(String.valueOf(P1));
        tb2.setText(String.valueOf(K1));
        tr.setText(String.valueOf(N50));

        crop = tv.getText().toString();
        choose(crop);
    }

    public void choose(String crop){
        switch (crop){
            case "sugarcane":
                pic.setImageResource(R.drawable.sugar_cane);
                break;
            case "cotton":
                pic.setImageResource(R.drawable.cotton);
                break;
            case "sunflower-rainfed":
                pic.setImageResource(R.drawable.sunflower_1);
                break;
            case "sunflower-irrigated":
                pic.setImageResource(R.drawable.sunflower_2);
                break;
            case "rice-p":
                pic.setImageResource(R.drawable.rice_1);
                break;
            case "rice-k":
                pic.setImageResource(R.drawable.rice);
                break;


        }

    }
}
