package com.example.secondproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    ArrayList<File> list;
    GridView gridView;
    String textColor;
    int textSize;
    String GeoLocation;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Intent intent= getIntent();
        textColor=intent.getStringExtra("color");
        textSize=intent.getIntExtra("size",14);
        GeoLocation=intent.getStringExtra("geoLocation");


        gridView=findViewById(R.id.image_GridView);
        list = imageReader(Environment.getExternalStorageDirectory());
        gridView.setAdapter(new gridAdapter());

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(GalleryActivity.this,FullImageActivity.class);
                intent.putExtra("img",list.get(position).toString());
                intent.putExtra("color",textColor);
                intent.putExtra("size",textSize);
                intent.putExtra("geoLocation",GeoLocation);
                startActivity(intent);
            }
        });

    }

    public class gridAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=null;
            if(view == null){
                view=getLayoutInflater().inflate(R.layout.row_layout,parent,false);
                ImageView myImage=(ImageView) view.findViewById(R.id.myImage);
                myImage.setImageURI(Uri.parse(list.get(position).toString()));
            }
            return view;
        }
    }

    private ArrayList<File> imageReader(File esd){
        ArrayList<File> list = new ArrayList<>();
        File[] files = esd.listFiles();

        for(int i=0;i<files.length;i++){
            if(files[i].isDirectory()){
                list.addAll(imageReader(files[i]));
            }else{
                if(files[i].getName().endsWith(".jpg")){
                    list.add(files[i]);
                }
            }
        }
        return list;
    }
}
