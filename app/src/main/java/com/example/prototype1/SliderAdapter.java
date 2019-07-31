package com.example.prototype1;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class SliderAdapter<onCreate> extends PagerAdapter {

    int j=0;

    Context context;
    LayoutInflater layoutInflater;

    public int decide(){
        j=0;
        return j;
    }
    public int decide1(){
        j=1;
        return j;
    }
    public int decide2(){
        j=2;
        return j;
    }
    public int decide3(){
        j=3;
        return j;
    }

    /*Intent intent = getIntent(Language.class);
    int num= intent.getIntExtra("val",0);*/






    public SliderAdapter(Context context) {
        this.context = context;


    }



    public int[] slide_image = {
            R.drawable.fertilizer, R.drawable.pesticide,R.drawable.thermometer
    };

    public String[] slide_headings = {
            "Fertilizer", "PESTICIDES","WEATHER"
    };
    public String[] slide_description = {

            "Enter the required values for getting the information about suitable fertilizer ",
            "Enter the required values for getting the information about suitable pesticide ",
            "Click to see the weather report for your location",
            "Click to enter into the Community Page",
    };

    public int[] slide_image1 = {
            R.drawable.fertilizer, R.drawable.pesticide,R.drawable.thermometer
    };

    public String[] slide_headings1 = {
            "உரம்", "பூச்சிக்கொல்லி","வானிலை","சமூக பக்கம்","டாஷ்போர்டு"
    };
    public String[] slide_description1 = {

            "உங்கள் விவசாய நிலத்தில் பயன்படுத்தப்பட வேண்டிய உரத்தின் அளவை கணிக்க கீழே உள்ள பொத்தானைக் கிளிக் செய்க ",
            "உங்கள் விளைநிலங்களில் பயன்படுத்தப்பட வேண்டிய பூச்சிக்கொல்லியின் அளவை கணிக்க கீழே உள்ள பொத்தானைக் கிளிக் செய்க",
            "வானிலை முடிவு பற்றிய தகவல்களைப் பெற கீழே உள்ள பொத்தானைக் கிளிக் செய்க",
            "எங்கள் சமூக பக்கத்தில் உங்கள் கருத்துக்களைப் பகிர கீழே உள்ள பொத்தானைக் கிளிக் செய்க",
    };

    public int[] slide_image2 = {
            R.drawable.fertilizer, R.drawable.pesticide,R.drawable.thermometer
    };

    public String[] slide_headings2 = {
            "उर्वरक", "कीटनाशक","मौसम","सामुदायिक पेज","डैशबोर्ड"
    };
    public String[] slide_description2 = {

            "अपने खेत की भूमि में उपयोग किए जाने वाले उर्वरक की मात्रा का अनुमान लगाने के लिए नीचे दिए गए बटन पर क्लिक करें ",
            "अपने खेत की जमीन में इस्तेमाल होने वाले उर्वरक के बारे में भविष्यवाणी करने के लिए नीचे दिए गए बटन पर क्लिक करें",
            "अपने क्षेत्र में मौसम के बारे में जानकारी प्राप्त करने के लिए नीचे दिए गए बटन पर क्लिक करें",
            "हमारे समुदाय पृष्ठ में अपने विचार साझा करने के लिए नीचे दिए गए बटन पर क्लिक करें",
    };

    public int[] slide_image3 = {
            R.drawable.fertilizer, R.drawable.pesticide,R.drawable.thermometer

    };

    public String[] slide_headings3 = {
            "ఎరువులు", "పెస్టిసైడ్","వాతావరణ","సంఘం పేజీ","డాష్బోర్డ్"
    };
    public String[] slide_description3 = {

            "మీ వ్యవసాయ భూమిలో ఎరువుల మొత్తాన్ని అంచనా వేయడానికి క్రింది బటన్Cను క్లిక్ చేయండి",
            "మీ వ్యవసాయ భూమిలో ఉపయోగించాల్సిన పురుగుమందుల మొత్తాన్ని అంచనా వేయడానికి క్రింది బటన్ను క్లిక్ చేయండి",
            "మీ ప్రాంత వాతావరణం గురించి సమాచారం పొందడానికి ఇక్కడ క్లిక్ చేయండి",
            "మా సంఘం పేజీలో మీ అభిప్రాయాన్ని పంచుకోవడానికి క్రింది బటన్ను క్లిక్ చేయండి",
    };



    @Override
    public int getCount() {
        return slide_headings.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.english_layout, container, false);

        ImageView slide_images = (ImageView) view.findViewById(R.id.imageView);
        TextView slide_head = (TextView) view.findViewById(R.id.textView2);
        TextView slide_desc = (TextView) view.findViewById(R.id.textView3);


        if(j==0) {
            slide_images.setImageResource(slide_image[position]);
            slide_head.setText(slide_headings[position]);
            slide_desc.setText(slide_description[position]);
        }
        if(j==1) {
            slide_images.setImageResource(slide_image1[position]);
            slide_head.setText(slide_headings1[position]);
            slide_desc.setText(slide_description1[position]);

        }
        if(j==2) {
            slide_images.setImageResource(slide_image2[position]);
            slide_head.setText(slide_headings2[position]);
            slide_desc.setText(slide_description2[position]);
        }
        if(j==3) {
            slide_images.setImageResource(slide_image3[position]);
            slide_head.setText(slide_headings3[position]);
            slide_desc.setText(slide_description3[position]);
        }
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }



}



