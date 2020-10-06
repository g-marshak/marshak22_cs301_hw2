package com.example.cs301_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * main activity of the app, sets up functionality of the actual interface
 * to create a face
 *
 * @author gabby marshak
 */

public class MainActivity extends AppCompatActivity {
    /**
     External Citation
     Date: 9/11/2020
     Problem: had to get spinner working/displaying different options
     Resource: used demo code from class to reference
     Solution: modeled off of the demo code
     */

    String[] hairstyles = {"Shaved", "Short", "Medium", "Long"} ;

    private Spinner hairSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Face face = findViewById(R.id.faceDisplay);

        //setting up spinner to use the array of hairstyles
        hairSpinner = findViewById(R.id.hairSpinner);
        ArrayAdapter<String> hairstyleAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                this.hairstyles
        );

        //connecting spinner and adapter so spinner will display test from array
        hairSpinner.setAdapter(hairstyleAdapter);
    }
}