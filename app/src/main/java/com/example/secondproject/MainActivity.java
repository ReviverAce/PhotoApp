package com.example.secondproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import  static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MainActivity extends AppCompatActivity {

    Button photoButton;
    Button galleryButton;
    Button settingsButton;
    Button exitButton;
    String textColor = "#000000";
    int textSize = 14;
    int radius = 100;
    String toastString = "There are photos near your radius";
    String GeoLocation="WonderLand";
    Location currentLocation;
    Location photoLocation;

    public static final int REQUEST_IMAGE_CAPTURE = 101;
    public static final int REQUEST_SETTINGS_OPTIONS = 102;

    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photoButton = findViewById(R.id.photoButton);
        galleryButton = findViewById(R.id.galleryButton);
        settingsButton = findViewById(R.id.settingsButton);
        exitButton = findViewById(R.id.exitButton);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        //current location
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationClient.getLastLocation().addOnSuccessListener(MainActivity.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

                if(location!=null){
                    currentLocation = new Location("");
                    currentLocation.setLatitude(location.getLatitude());
                    currentLocation.setLongitude(location.getLongitude());

                }else{
                    galleryButton.setText("wololo");
                }

            }
        });
        //===

        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
//                exitButton.setText(pathToFile);

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                fusedLocationClient.getLastLocation().addOnSuccessListener(MainActivity.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        if(location!=null){
                            double latitude = location.getLatitude();
                            double longitude = location.getLongitude();
                            GeoLocation = hereLocation(latitude,longitude);
                            photoLocation = new Location("");
                            photoLocation.setLatitude(location.getLatitude());
                            photoLocation.setLongitude(location.getLongitude());

//                            galleryButton.setText(latitude+" "+longitude);
//                            galleryButton.setText(GeoLocation);

                        }else{
                            galleryButton.setText("wololo");
                        }

                    }
                });

            }
        });

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),GalleryActivity.class);
                intent.putExtra("color",textColor);
                intent.putExtra("size",textSize);
                intent.putExtra("geoLocation",GeoLocation);
                startActivity(intent);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SettingsActivity.class);
                intent.putExtra("color",textColor);
                intent.putExtra("size",textSize);
                intent.putExtra("radius",radius);
                startActivityForResult(intent,REQUEST_SETTINGS_OPTIONS);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_SETTINGS_OPTIONS){
        if(resultCode == RESULT_OK){
            textColor=data.getStringExtra("color");
            textSize=data.getIntExtra("size",14);
            radius=data.getIntExtra("radius",100);

            if(currentLocation!= null && photoLocation!=null) {
                if(radius>currentLocation.distanceTo(photoLocation)){
                    Toast.makeText(getApplicationContext(),toastString,Toast.LENGTH_LONG).show();
                }
            }

        }
        }

        if(requestCode==REQUEST_IMAGE_CAPTURE){
            if(resultCode == RESULT_OK){
                File f = getFileStreamPath(fileName);
                if(f.length()==0){
                    f.delete();
                }
            }
        }
    }

    //=========
    String pathToFile;
    String fileName;

    private File createPhotoFile(){
        String name = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = null;
        try{
            image = File.createTempFile(name,".jpg",dir);
        }catch (Exception ex){

        }

        return image;
    }

    private void dispatchTakePictureIntent(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null){
            File photoFile = null;
            photoFile = createPhotoFile();
            if (photoFile != null) {
                pathToFile = photoFile.getAbsolutePath();
                fileName=photoFile.getName();
                Uri photoURI = FileProvider.getUriForFile(MainActivity.this,"com.example.secondproject.fileprovider",photoFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,photoURI);
                startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
            }

        }
    }

    //find location
    private String hereLocation(double lat, double lon){
        String cityName="";
        String countryName="";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> adressList;
        try{
            adressList=geocoder.getFromLocation(lat,lon,10);
            if(adressList.size()>0){
                for(Address adr: adressList){
                    if(adr.getLocality()!= null && adr.getLocality().length()>0){
                        cityName=adr.getLocality();
                        countryName=adr.getCountryName();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cityName+" "+countryName;
    }

    //bitmap
    private Bitmap textOnImage(String text){
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(textSize);
        paint.setColor(Color.parseColor(textColor));
        paint.setTextAlign(Paint.Align.LEFT);
        float baseLine = -paint.ascent();
        int width = (int) (paint.measureText(text)+0.5f);
        int height = (int) (baseLine + paint.descent()+0.5f);
        Bitmap image = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(image);
        canvas.drawText(text,0,baseLine,paint);
        return image;
    }


}
