package com.example.cs301_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
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
    private RadioGroup colorSelect;
    private SeekBar redSeek;
    private SeekBar blueSeek;
    private SeekBar greenSeek;
    private Button randomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Face face = findViewById(R.id.faceDisplay);

        //creating facecontroller instance
        FaceController controller = new FaceController(face);

        //setting up spinner to use the array of hairstyles
        hairSpinner = findViewById(R.id.hairSpinner);
        ArrayAdapter<String> hairstyleAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                this.hairstyles
        );

        //connecting spinner and adapter so spinner will display test from array (and connecting to controller)
        hairSpinner.setAdapter(hairstyleAdapter);
        hairSpinner.setOnItemSelectedListener(controller);

        //setting up radio button group
        colorSelect = findViewById(R.id.colorSelectionGroup);
        colorSelect.setOnCheckedChangeListener(controller);

        //setting up seekbars
        redSeek = findViewById(R.id.red);
        redSeek.setOnSeekBarChangeListener(controller);
        blueSeek = findViewById(R.id.blue);
        blueSeek.setOnSeekBarChangeListener(controller);
        greenSeek = findViewById(R.id.green);
        greenSeek.setOnSeekBarChangeListener(controller);

        //setting up randomize button
        randomButton = findViewById(R.id.randomFace);
        randomButton.setOnClickListener(controller);
    }
}