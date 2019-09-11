package com.example.secondproject;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FullImageActivity extends AppCompatActivity {

    ImageView fullImage;
    TextView locationTextView;
    String textColor;
    int textSize;
    String GeoLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        fullImage = findViewById(R.id.fullImage);
        locationTextView = findViewById(R.id.locationTextView);

        Intent intent= getIntent();
        textColor=intent.getStringExtra("color");
        textSize=intent.getIntExtra("size",14);
        GeoLocation=intent.getStringExtra("geoLocation");

        locationTextView.setTextSize(textSize);
        locationTextView.setText(GeoLocation);

        switch(textColor){
            case "#000000":
                locationTextView.setTextColor(Color.parseColor(textColor));
                break;
            case "#595959":
                locationTextView.setTextColor(Color.parseColor(textColor));
                break;
            case "#a0491b":
                locationTextView.setTextColor(Color.parseColor(textColor));
                break;
            case "#ff0000":
                locationTextView.setTextColor(Color.parseColor(textColor));
                break;
            case "#10ff00":
                locationTextView.setTextColor(Color.parseColor(textColor));
                break;
            case "#0077ff":
                locationTextView.setTextColor(Color.parseColor(textColor));
                break;
            case "#ff00e1":
                locationTextView.setTextColor(Color.parseColor(textColor));
                break;
            case "#fff600":
                locationTextView.setTextColor(Color.parseColor(textColor));
                break;
            case "#571aa3":
                locationTextView.setTextColor(Color.parseColor(textColor));
                break;
            case "#63391a":
                locationTextView.setTextColor(Color.parseColor(textColor));
                break;
            case "#ffffff":
                locationTextView.setTextColor(Color.parseColor(textColor));
                break;
            default:
        }

        String data = getIntent().getExtras().getString("img");
        fullImage.setImageURI(Uri.parse(data));
    }
}
