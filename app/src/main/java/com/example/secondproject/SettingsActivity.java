package com.example.secondproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    SeekBar colorSeekBar;
    SeekBar sizeSeekBar;
    SeekBar radiusSeekBar;
    TextView colorTextView;
    TextView sizeTextView;
    TextView radiusTextView;
    TextView colorValueTextView;
    TextView sizeValueTextView;
    TextView radiusValueTextView;
    Button backButton;

    String textColor;
    int textSize;
    int radius;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        colorSeekBar=findViewById(R.id.colorSeekBar);
        sizeSeekBar=findViewById(R.id.sizeSeekBar);
        radiusSeekBar=findViewById(R.id.radiusSeekBar);
        colorTextView=findViewById(R.id.colorTextView);
        sizeTextView=findViewById(R.id.sizeTextView);
        radiusTextView=findViewById(R.id.radiusTextView);
        colorValueTextView=findViewById(R.id.colorValueTextView);
        sizeValueTextView=findViewById(R.id.sizeValueTextView);
        radiusValueTextView=findViewById(R.id.radiusValueTextView);
        backButton=findViewById(R.id.backButton);



        Intent intent= getIntent();
        textColor=intent.getStringExtra("color");
        textSize=intent.getIntExtra("size",14);
        radius=intent.getIntExtra("radius",100);

        switch(textColor){
                case "#000000":
                    colorValueTextView.setText("black");
                    colorValueTextView.setTextColor(Color.parseColor(textColor));
                    colorSeekBar.setProgress(0);
                    break;
                case "#595959":
                    colorValueTextView.setText("gray");
                    colorValueTextView.setTextColor(Color.parseColor(textColor));
                    colorSeekBar.setProgress(1);
                    break;
                case "#a0491b":
                    colorValueTextView.setText("orange");
                    colorValueTextView.setTextColor(Color.parseColor(textColor));
                    colorSeekBar.setProgress(2);
                    break;
                case "#ff0000":
                    colorValueTextView.setText("red");
                    colorValueTextView.setTextColor(Color.parseColor(textColor));
                    colorSeekBar.setProgress(3);
                    break;
                case "#10ff00":
                    colorValueTextView.setText("green");
                    colorValueTextView.setTextColor(Color.parseColor(textColor));
                    colorSeekBar.setProgress(4);
                    break;
                case "#0077ff":
                    colorValueTextView.setText("blue");
                    colorValueTextView.setTextColor(Color.parseColor(textColor));
                    colorSeekBar.setProgress(5);
                    break;
                case "#ff00e1":
                    colorValueTextView.setText("pink");
                    colorValueTextView.setTextColor(Color.parseColor(textColor));
                    colorSeekBar.setProgress(6);
                    break;
                case "#fff600":
                    colorValueTextView.setText("yellow");
                    colorValueTextView.setTextColor(Color.parseColor(textColor));
                    colorSeekBar.setProgress(7);
                    break;
                case "#571aa3":
                    colorValueTextView.setText("purple");
                    colorValueTextView.setTextColor(Color.parseColor(textColor));
                    colorSeekBar.setProgress(8);
                    break;
                case "#63391a":
                    colorValueTextView.setText("brown");
                    colorValueTextView.setTextColor(Color.parseColor(textColor));
                    colorSeekBar.setProgress(9);
                    break;
                case "#ffffff":
                    colorValueTextView.setText("white");
                    colorValueTextView.setTextColor(Color.parseColor(textColor));
                    colorSeekBar.setProgress(10);
                    break;
                default:
        }

        switch(textSize){
            case 14:
                sizeValueTextView.setText(textSize+"sp");
                sizeValueTextView.setTextSize(textSize);
                sizeSeekBar.setProgress(0);
                break;
            case 18:
                sizeValueTextView.setText(textSize+"sp");
                sizeValueTextView.setTextSize(textSize);
                sizeSeekBar.setProgress(1);
                break;
            case 22:
                sizeValueTextView.setText(textSize+"sp");
                sizeValueTextView.setTextSize(textSize);
                sizeSeekBar.setProgress(2);
                break;
            case 26:
                sizeValueTextView.setText(textSize+"sp");
                sizeValueTextView.setTextSize(textSize);
                sizeSeekBar.setProgress(3);
                break;
            case 30:
                sizeValueTextView.setText(textSize+"sp");
                sizeValueTextView.setTextSize(textSize);
                sizeSeekBar.setProgress(4);
                break;
            case 34:
                sizeValueTextView.setText(textSize+"sp");
                sizeValueTextView.setTextSize(textSize);
                sizeSeekBar.setProgress(5);
                break;
            case 38:
                sizeValueTextView.setText(textSize+"sp");
                sizeValueTextView.setTextSize(textSize);
                sizeSeekBar.setProgress(6);
                break;
            case 42:
                sizeValueTextView.setText(textSize+"sp");
                sizeValueTextView.setTextSize(textSize);
                sizeSeekBar.setProgress(7);
                break;
            case 46:
                sizeValueTextView.setText(textSize+"sp");
                sizeValueTextView.setTextSize(textSize);
                sizeSeekBar.setProgress(8);
                break;
            case 50:
                sizeValueTextView.setText(textSize+"sp");
                sizeValueTextView.setTextSize(textSize);
                sizeSeekBar.setProgress(9);
                break;
            case 54:
                sizeValueTextView.setText(textSize+"sp");
                sizeValueTextView.setTextSize(textSize);
                sizeSeekBar.setProgress(10);
                break;
                default:

        }

        switch(radius){
            case 100:
                radiusValueTextView.setText("100m");
                radiusSeekBar.setProgress(0);
                break;
            case 250:
                radiusValueTextView.setText("250m");
                radiusSeekBar.setProgress(1);
                break;
            case 500:
                radiusValueTextView.setText("500m");
                radiusSeekBar.setProgress(2);
                break;
            case 1000:
                radiusValueTextView.setText("1km");
                radiusSeekBar.setProgress(3);
                break;
            case 5000:
                radiusValueTextView.setText("5km");
                radiusSeekBar.setProgress(4);
                break;
            case 10000:
                radiusValueTextView.setText("10km");
                radiusSeekBar.setProgress(5);
                break;
            case 25000:
                radiusValueTextView.setText("25km");
                radiusSeekBar.setProgress(6);
                break;
            case 50000:
                radiusValueTextView.setText("50km");
                radiusSeekBar.setProgress(7);
                break;
            case 100000:
                radiusValueTextView.setText("100km");
                radiusSeekBar.setProgress(8);
                break;
            case 250000:
                radiusValueTextView.setText("250km");
                radiusSeekBar.setProgress(9);
                break;
            case 500000:
                radiusValueTextView.setText("500km");
                radiusSeekBar.setProgress(10);
                break;
            default:
        }


        colorSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch(progress){
                    case 0:
                        colorValueTextView.setText("black");
                        colorValueTextView.setTextColor(Color.parseColor("#000000"));
                        textColor="#000000";
                        break;
                    case 1:
                        colorValueTextView.setText("gray");
                        colorValueTextView.setTextColor(Color.parseColor("#595959"));
                        textColor="#595959";
                        break;
                    case 2:
                        colorValueTextView.setText("orange");
                        colorValueTextView.setTextColor(Color.parseColor("#a0491b"));
                        textColor="#a0491b";
                        break;
                    case 3:
                        colorValueTextView.setText("red");
                        colorValueTextView.setTextColor(Color.parseColor("#ff0000"));
                        textColor="#ff0000";
                        break;
                    case 4:
                        colorValueTextView.setText("green");
                        colorValueTextView.setTextColor(Color.parseColor("#10ff00"));
                        textColor="#10ff00";
                        break;
                    case 5:
                        colorValueTextView.setText("blue");
                        colorValueTextView.setTextColor(Color.parseColor("#0077ff"));
                        textColor="#0077ff";
                        break;
                    case 6:
                        colorValueTextView.setText("pink");
                        colorValueTextView.setTextColor(Color.parseColor("#ff00e1"));
                        textColor="#ff00e1";
                        break;
                    case 7:
                        colorValueTextView.setText("yellow");
                        colorValueTextView.setTextColor(Color.parseColor("#fff600"));
                        textColor="#fff600";
                        break;
                    case 8:
                        colorValueTextView.setText("purple");
                        colorValueTextView.setTextColor(Color.parseColor("#571aa3"));
                        textColor="#571aa3";
                        break;
                    case 9:
                        colorValueTextView.setText("brown");
                        colorValueTextView.setTextColor(Color.parseColor("#63391a"));
                        textColor="#63391a";
                        break;
                    case 10:
                        colorValueTextView.setText("white");
                        colorValueTextView.setTextColor(Color.parseColor("#ffffff"));
                        textColor="#ffffff";
                        break;
                        default:

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch(progress){
                    case 0:
                        sizeValueTextView.setText("14sp");
                        sizeValueTextView.setTextSize(14);
                        textSize=14;
                        break;
                    case 1:
                        sizeValueTextView.setText("18sp");
                        sizeValueTextView.setTextSize(18);
                        textSize=18;
                        break;
                    case 2:
                        sizeValueTextView.setText("22sp");
                        sizeValueTextView.setTextSize(22);
                        textSize=22;
                        break;
                    case 3:
                        sizeValueTextView.setText("26sp");
                        sizeValueTextView.setTextSize(26);
                        textSize=26;
                        break;
                    case 4:
                        sizeValueTextView.setText("30sp");
                        sizeValueTextView.setTextSize(30);
                        textSize=30;
                        break;
                    case 5:
                        sizeValueTextView.setText("34sp");
                        sizeValueTextView.setTextSize(34);
                        textSize=34;
                        break;
                    case 6:
                        sizeValueTextView.setText("38sp");
                        sizeValueTextView.setTextSize(38);
                        textSize=38;
                        break;
                    case 7:
                        sizeValueTextView.setText("42sp");
                        sizeValueTextView.setTextSize(42);
                        textSize=42;
                        break;
                    case 8:
                        sizeValueTextView.setText("46sp");
                        sizeValueTextView.setTextSize(46);
                        textSize=46;
                        break;
                    case 9:
                        sizeValueTextView.setText("50sp");
                        sizeValueTextView.setTextSize(50);
                        textSize=50;
                        break;
                    case 10:
                        sizeValueTextView.setText("54sp");
                        sizeValueTextView.setTextSize(54);
                        textSize=54;
                        break;
                    default:

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        radiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch(progress){
                    case 0:
                        radiusValueTextView.setText("100m");
                        radius=100;
                        break;
                    case 1:
                        radiusValueTextView.setText("250m");
                        radius=250;
                        break;
                    case 2:
                        radiusValueTextView.setText("500m");
                        radius=500;
                        break;
                    case 3:
                        radiusValueTextView.setText("1km");
                        radius=1000;
                        break;
                    case 4:
                        radiusValueTextView.setText("5km");
                        radius=5000;
                        break;
                    case 5:
                        radiusValueTextView.setText("10km");
                        radius=10000;
                        break;
                    case 6:
                        radiusValueTextView.setText("25km");
                        radius=25000;
                        break;
                    case 7:
                        radiusValueTextView.setText("50km");
                        radius=50000;
                        break;
                    case 8:
                        radiusValueTextView.setText("100km");
                        radius=100000;
                        break;
                    case 9:
                        radiusValueTextView.setText("250km");
                        radius=250000;
                        break;
                    case 10:
                        radiusValueTextView.setText("500km");
                        radius=500000;
                        break;
                    default:

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent();
                resultIntent.putExtra("color",textColor);
                resultIntent.putExtra("size",textSize);
                resultIntent.putExtra("radius",radius);

                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });
    }
}
