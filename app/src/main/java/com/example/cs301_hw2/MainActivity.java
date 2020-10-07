package com.example.cs301_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.util.Random;

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
        Random rand = new Random();

        Face face = findViewById(R.id.faceDisplay);

        //init seekbars up here so i can pass them into the controller
        redSeek = findViewById(R.id.red);
        greenSeek = findViewById(R.id.green);
        blueSeek = findViewById(R.id.blue);

        //creating facecontroller instance
        FaceController controller = new FaceController(face, redSeek, greenSeek, blueSeek);

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
        hairSpinner.setSelection(rand.nextInt(4)); //manually randomizing hairstyle on setup

        //setting up radio button group
        colorSelect = findViewById(R.id.colorSelectionGroup);
        colorSelect.setOnCheckedChangeListener(controller);

        //setting up seekbars cont
        redSeek.setOnSeekBarChangeListener(controller);
        greenSeek.setOnSeekBarChangeListener(controller);
        blueSeek.setOnSeekBarChangeListener(controller);

        //setting default values for seekbars to whatever the hair color values are randomized to (hair button is checked by default)
        redSeek.setProgress(face.getHairColorR());
        greenSeek.setProgress(face.getHairColorG());
        blueSeek.setProgress(face.getHairColorB());

        //setting up randomize button
        randomButton = findViewById(R.id.randomFace);
        randomButton.setOnClickListener(controller);
    }
}