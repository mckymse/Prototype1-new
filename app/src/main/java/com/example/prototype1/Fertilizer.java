package com.example.prototype1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Fertilizer extends AppCompatActivity {


    String crop;
    int N, P, K;
    int A,B,C;
    int N1,N2,N3;
    Spinner mSpinner;
    TextView mOutputSpinner;
    String[] mOptions = {"----Select----","Sugarcane","Cotton","Rice-K","Rice-P","Sunflower-Rainfed","Sunflower-Irrigated"};
    ImageView imageView;

    String Crop_name;
    EditText Nitrogen_content;
    EditText Phosphate_content;
    EditText Potassium_content;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer);

        imageView = findViewById(R.id.fert_pic);
        mSpinner=findViewById(R.id.spinner);

        ArrayAdapter a=new ArrayAdapter(Fertilizer.this,android.R.layout.simple_spinner_item,mOptions);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(a);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1){
                    Crop_name="sugarcane";
                    imageView.setImageResource(R.drawable.sugar_cane);


                }
                if(i==2){
                    Crop_name="cotton";
                    imageView.setImageResource(R.drawable.cotton);

                }
                if(i==3){
                    Crop_name="rice-k";
                    imageView.setImageResource(R.drawable.rice);

                }
                if(i==4){
                    Crop_name="rice-p";
                    imageView.setImageResource(R.drawable.rice_1);


                }
                if(i==5){
                    Crop_name="sunflower-rainfed";
                    imageView.setImageResource(R.drawable.sunflower_1);

                }
                if(i==6){
                    Crop_name="sunflower-irrigated";
                    imageView.setImageResource(R.drawable.sunflower_2);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        Nitrogen_content =  findViewById(R.id.Nitrogen_content);
        Phosphate_content =  findViewById(R.id.Phoshpate_content);
        Potassium_content =  findViewById(R.id.Potassium_content);
        button =  findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crop = Crop_name.toLowerCase();/*
                N = Integer.valueOf(Nitrogen_content.getText().toString());
                P = Integer.valueOf(Phosphate_content.getText().toString());
                K = Integer.valueOf(Potassium_content.getText().toString());*/
                N=cropnitrogen(Integer.parseInt(Nitrogen_content.getText().toString())/*,crop*/);
                P=cropphosphate(Integer.parseInt(Potassium_content.getText().toString())/*,crop*/);
                K=croppotassium(Integer.parseInt(Phosphate_content.getText().toString())/*,crop*/);
                Intent intent = new Intent(Fertilizer.this,Fertilizer_result.class);
                Choose_crop(crop);
                /*N1=sugarcane_N(P,K);
                N2=sugarcane_P(P,K);
                N3=sugarcane_K(P,K);*/
                intent.putExtra("Name",crop);
                intent.putExtra("value1",N1);
                intent.putExtra("value2",N2);
                intent.putExtra("value3",N3);
                startActivity(intent);
            }
        });
    }

    private int cropnitrogen(int c){
        return c;
    }

    private int croppotassium(int a){
        int a1=0;
        if(a<=110)
        {
            a1= -1;
        }if((a>111)&&(a<280)){
            a1= 0;
        }if(a>280){
            a1= 1;
        }
        return a1;

    }
    private int cropphosphate(int b){
        int b1=0;
        if(b<=11)
        {
            b1=-1;
        }if((b>11)&&(b<22)){
            b1=0;
        }if(b>22){
            b1=1;
        }
        return b1;
    }

    public void Choose_crop(String crop){
        switch (crop){
            case "sugarcane":
                N1=sugarcane_N(P,K);
                N2=sugarcane_P(P,K);
                N3=sugarcane_K(P,K);
                break;
            case "cotton":
                N1=Cotton_N(P,K);
                N2=Cotton_P(P,K);
                N3=Cotton_K(P,K);
                break;
            case "rice-k":
                N1=Rice1_N(P,K);
                N2=Rice1_P(P,K);
                N3=Rice1_K(P,K);
                break;
            case "rice-p":
                N1=Rice2_N(P,K);
                N2=Rice2_P(P,K);
                N3=Rice2_K(P,K);
                break;
            case "sunflower-rainfed":
                N1=Sunflower1_N(P,K);
                N2=Sunflower1_P(P,K);
                N3=Sunflower1_K(P,K);
                break;
            case "sunflower-irrigated":
                N1=Sunflower2_N(P,K);
                N2=Sunflower2_P(P,K);
                N3=Sunflower2_K(P,K);
                break;
        }
    }

    private int sugarcane_N(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=225;

        }
        if((p==-1)&&(k==0)){
            N=225;

        }if((p==-1)&&(k==1)){
            N=225;

        }if((p==0)&&(k==-1)){
            N=225;

        }if((p==0)&&(k==0)){
            N=225;

        }if((p==0)&&(k==1)){
            N=225;

        }if((p==1)&&(k==-1)){
            N=225;

        }if((p==1)&&(k==0)){
            N=225;

        }if((p==1)&&(k==1)){
            N=225;

        }
        return N;
    }
    private int sugarcane_P(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=60;

        }
        if((p==-1)&&(k==0)){
            N=60;

        }if((p==-1)&&(k==1)){
            N=60;

        }if((p==0)&&(k==-1)){
            N=30;

        }if((p==0)&&(k==0)){
            N=30;

        }if((p==0)&&(k==1)){
            N=30;

        }if((p==1)&&(k==-1)){
            N=0;

        }if((p==1)&&(k==0)){
            N=0;

        }if((p==1)&&(k==1)){
            N=0;

        }
        return N;
    }
    private int sugarcane_K(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=120;

        }
        if((p==-1)&&(k==0)){
            N=60;

        }if((p==-1)&&(k==1)){
            N=0;

        }if((p==0)&&(k==-1)){
            N=120;

        }if((p==0)&&(k==0)){
            N=60;

        }if((p==0)&&(k==1)){
            N=0;

        }if((p==1)&&(k==-1)){
            N=120;

        }if((p==1)&&(k==0)){
            N=60;

        }if((p==1)&&(k==1)){
            N=0;

        }
        return N;
    }
    private int Cotton_N(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=120;
        }
        if((p==-1)&&(k==0)){
            N=120;

        }if((p==-1)&&(k==1)){
            N=120;

        }if((p==0)&&(k==-1)){
            N=120;

        }if((p==0)&&(k==0)){
            N=120;

        }if((p==0)&&(k==1)){
            N=120;

        }if((p==1)&&(k==-1)){
            N=120;

        }if((p==1)&&(k==0)){
            N=120;

        }if((p==1)&&(k==1)){
            N=120;

        }
        return N;
    }
    private int Cotton_P(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=60;

        }
        if((p==-1)&&(k==0)){
            N=60;

        }if((p==-1)&&(k==1)){
            N=60;

        }if((p==0)&&(k==-1)){
            N=48;

        }if((p==0)&&(k==0)){
            N=48;

        }if((p==0)&&(k==1)){
            N=48;

        }if((p==1)&&(k==-1)){
            N=0;

        }if((p==1)&&(k==0)){
            N=0;

        }if((p==1)&&(k==1)){
            N=0;

        }
        return N;
    }
    private int Cotton_K(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=60;

        }
        if((p==-1)&&(k==0)){
            N=10;

        }if((p==-1)&&(k==1)){
            N=0;

        }if((p==0)&&(k==-1)){
            N=60;

        }if((p==0)&&(k==0)){
            N=10;

        }if((p==0)&&(k==1)){
            N=0;

        }if((p==1)&&(k==-1)){
            N=60;

        }if((p==1)&&(k==0)){
            N=10;

        }if((p==1)&&(k==1)){
            N=0;

        }
        return N;
    }
    private int Rice1_N(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=120;

        }
        if((p==-1)&&(k==0)){
            N=120;

        }if((p==-1)&&(k==1)){
            N=120;

        }if((p==0)&&(k==-1)){
            N=120;

        }if((p==0)&&(k==0)){
            N=120;

        }if((p==0)&&(k==1)){
            N=120;

        }if((p==1)&&(k==-1)){
            N=120;

        }if((p==1)&&(k==0)){
            N=120;

        }if((p==1)&&(k==1)){
            N=120;

        }
        return N;
    }
    private int Rice1_P(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=60;

        }
        if((p==-1)&&(k==0)){
            N=60;

        }if((p==-1)&&(k==1)){
            N=60;

        }if((p==0)&&(k==-1)){
            N=35;

        }if((p==0)&&(k==0)){
            N=35;

        }if((p==0)&&(k==1)){
            N=35;

        }if((p==1)&&(k==-1)){
            N=0;

        }if((p==1)&&(k==0)){
            N=0;

        }if((p==1)&&(k==1)){
            N=0;

        }
        return N;
    }
    private int Rice1_K(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=60;

        }
        if((p==-1)&&(k==0)){
            N=20;

        }if((p==-1)&&(k==1)){
            N=0;

        }if((p==0)&&(k==-1)){
            N=60;

        }if((p==0)&&(k==0)){
            N=20;

        }if((p==0)&&(k==1)){
            N=0;

        }if((p==1)&&(k==-1)){
            N=60;

        }if((p==1)&&(k==0)){
            N=20;

        }if((p==1)&&(k==1)){
            N=0;
        }
        return N;
    }
    private int Rice2_N(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=150;

        }
        if((p==-1)&&(k==0)){
            N=150;

        }if((p==-1)&&(k==1)){
            N=150;

        }if((p==0)&&(k==-1)){
            N=150;

        }if((p==0)&&(k==0)){
            N=150;

        }if((p==0)&&(k==1)){
            N=150;

        }if((p==1)&&(k==-1)){
            N=150;

        }if((p==1)&&(k==0)){
            N=150;

        }if((p==1)&&(k==1)){
            N=150;

        }
        return N;
    }
    private int Rice2_P(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=60;

        }
        if((p==-1)&&(k==0)){
            N=60;

        }if((p==-1)&&(k==1)){
            N=60;

        }if((p==0)&&(k==-1)){
            N=35;

        }if((p==0)&&(k==0)){
            N=35;

        }if((p==0)&&(k==1)){
            N=35;

        }if((p==1)&&(k==-1)){
            N=0;

        }if((p==1)&&(k==0)){
            N=0;

        }if((p==1)&&(k==1)){
            N=0;

        }
        return N;
    }
    private int Rice2_K(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=60;

        }
        if((p==-1)&&(k==0)){
            N=20;

        }if((p==-1)&&(k==1)){
            N=0;

        }if((p==0)&&(k==-1)){
            N=60;

        }if((p==0)&&(k==0)){
            N=20;

        }if((p==0)&&(k==1)){
            N=0;

        }if((p==1)&&(k==-1)){
            N=60;

        }if((p==1)&&(k==0)){
            N=20;

        }if((p==1)&&(k==1)){
            N=0;

        }
        return N;
    }
    private int Sunflower1_N(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=50;

        }
        if((p==-1)&&(k==0)){
            N=50;

        }if((p==-1)&&(k==1)){
            N=50;

        }if((p==0)&&(k==-1)){
            N=50;

        }if((p==0)&&(k==0)){
            N=50;

        }if((p==0)&&(k==1)){
            N=50;

        }if((p==1)&&(k==-1)){
            N=50;

        }if((p==1)&&(k==0)){
            N=50;

        }if((p==1)&&(k==1)){
            N=50;

        }
        return N;
    }
    private int Sunflower1_P(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=60;

        }
        if((p==-1)&&(k==0)){
            N=60;

        }if((p==-1)&&(k==1)){
            N=60;

        }if((p==0)&&(k==-1)){
            N=35;

        }if((p==0)&&(k==0)){
            N=35;

        }if((p==0)&&(k==1)){
            N=35;

        }if((p==1)&&(k==-1)){
            N=0;

        }if((p==1)&&(k==0)){
            N=0;

        }if((p==1)&&(k==1)){
            N=0;

        }
        return N;
    }
    private int Sunflower1_K(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=40;

        }
        if((p==-1)&&(k==0)){
            N=15;

        }if((p==-1)&&(k==1)){
            N=0;

        }if((p==0)&&(k==-1)){
            N=40;

        }if((p==0)&&(k==0)){
            N=15;

        }if((p==0)&&(k==1)){
            N=0;

        }if((p==1)&&(k==-1)){
            N=40;

        }if((p==1)&&(k==0)){
            N=15;

        }if((p==1)&&(k==1)){
            N=0;

        }
        return N;
    }
    private int Sunflower2_N(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=60;

        }
        if((p==-1)&&(k==0)){
            N=60;

        }if((p==-1)&&(k==1)){
            N=60;

        }if((p==0)&&(k==-1)){
            N=60;

        }if((p==0)&&(k==0)){
            N=60;

        }if((p==0)&&(k==1)){
            N=60;

        }if((p==1)&&(k==-1)){
            N=60;

        }if((p==1)&&(k==0)){
            N=60;

        }if((p==1)&&(k==1)){
            N=60;

        }
        return N;
    }
    private int Sunflower2_P(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=90;

        }
        if((p==-1)&&(k==0)){
            N=90;

        }if((p==-1)&&(k==1)){
            N=90;

        }if((p==0)&&(k==-1)){
            N=70;

        }if((p==0)&&(k==0)){
            N=70;

        }if((p==0)&&(k==1)){
            N=70;

        }if((p==1)&&(k==-1)){
            N=0;

        }if((p==1)&&(k==0)){
            N=0;

        }if((p==1)&&(k==1)){
            N=0;

        }
        return N;
    }
    private int Sunflower2_K(int p,int k){
        int N=0;

        if((p==-1)&&(k==-1)){
            N=60;

        }
        if((p==-1)&&(k==0)){
            N=15;

        }if((p==-1)&&(k==1)){
            N=0;

        }if((p==0)&&(k==-1)){
            N=60;

        }if((p==0)&&(k==0)){
            N=15;

        }if((p==0)&&(k==1)){
            N=0;

        }if((p==1)&&(k==-1)){
            N=60;

        }if((p==1)&&(k==0)){
            N=15;

        }if((p==1)&&(k==1)){
            N=0;
        }
        return N;
    }
}
