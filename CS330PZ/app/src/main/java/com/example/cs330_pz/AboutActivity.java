package com.example.cs330_pz;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView titlabout = (TextView) findViewById(R.id.titlabout);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);


    }
}
