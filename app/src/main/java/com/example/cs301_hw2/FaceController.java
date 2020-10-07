package com.example.cs301_hw2;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;

/**
 * class that controls changes in the face based on sliders/spinners/radio buttons
 */
public class FaceController implements SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private Face face;
    private SeekBar redSeek;
    private SeekBar greenSeek;
    private SeekBar blueSeek;

    /**
     External Citation
     Date: 10/6/2020
     Problem: wasn't sure how to change seekbar values from inside controller
     Resource: demo code from class
     Solution: checked to see how seekbar was changed from different listeners
               (i needed to pass them in like i did with the face)
     */
    public FaceController(Face f, SeekBar r, SeekBar g, SeekBar b){
        face = f;
        redSeek = r;
        greenSeek = g;
        blueSeek = b;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int seekNum, boolean fromUser) {
        //check what radiobutton is true
        //check what seekbar is being changed (rgb)
        //change r/g/b value based on that, then change overall color and invalidate to redraw

        switch(face.getColorSelectIndex()){
            case 0: //hair
                if(seekBar.getId() == R.id.red){
                    face.setHairColorR(seekNum);
                }else if(seekBar.getId() == R.id.green){
                    face.setHairColorG(seekNum);
                }else if(seekBar.getId() == R.id.blue){
                    face.setHairColorB(seekNum);
                }

                //update hair color
                face.setHairColor(face.getHairColorR(), face.getHairColorG(), face.getHairColorB());
                break;
            case 1: //eyes
                if(seekBar.getId() == R.id.red){
                    face.setEyeColorR(seekNum);
                }else if(seekBar.getId() == R.id.green){
                    face.setEyeColorG(seekNum);
                }else if(seekBar.getId() == R.id.blue){
                    face.setEyeColorB(seekNum);
                }

                //update eye color
                face.setEyeColor(face.getEyeColorR(), face.getEyeColorG(), face.getEyeColorB());
                break;
            case 2: //skin
                if(seekBar.getId() == R.id.red){
                    face.setSkinColorR(seekNum);
                }else if(seekBar.getId() == R.id.green){
                    face.setSkinColorG(seekNum);
                }else if(seekBar.getId() == R.id.blue){
                    face.setSkinColorB(seekNum);
                }

                //update skin color
                face.setSkinColor(face.getSkinColorR(), face.getSkinColorG(), face.getSkinColorB());
                break;
            default: //none selected
                //dont change anything
        }

        face.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //dont care about this
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //dont care about this either
    }

    /**
     External Citation
     Date: 10/6/2020
     Problem: was unsure of how to get information from spinner when it changes
     Resource: https://developer.android.com/reference/android/widget/AdapterView.OnItemSelectedListener
     Solution: looked up the listener/documentation for spinners, used it
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        //sets hairstyle based on position in array, then invalidates to redraw
        face.setHairStyle(position);
        face.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //dont care about this
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int index) {
        if(index == R.id.hair){
            face.setColorSelectIndex(0);
            redSeek.setProgress(face.getHairColorR());
            greenSeek.setProgress(face.getHairColorG());
            blueSeek.setProgress(face.getHairColorB());
        } else if(index == R.id.eyes){
            face.setColorSelectIndex(1);
            redSeek.setProgress(face.getEyeColorR());
            greenSeek.setProgress(face.getEyeColorG());
            blueSeek.setProgress(face.getEyeColorB());
        } else if(index == R.id.skin){
            face.setColorSelectIndex(2);
            redSeek.setProgress(face.getSkinColorR());
            greenSeek.setProgress(face.getSkinColorG());
            blueSeek.setProgress(face.getSkinColorB());
        }
    }

    @Override
    public void onClick(View view) {
        face.randomize();
        switch (face.getColorSelectIndex()){
            case 0:
                redSeek.setProgress(face.getHairColorR());
                greenSeek.setProgress(face.getHairColorG());
                blueSeek.setProgress(face.getHairColorB());
                break;
            case 1:
                redSeek.setProgress(face.getEyeColorR());
                greenSeek.setProgress(face.getEyeColorG());
                blueSeek.setProgress(face.getEyeColorB());
                break;
            case 2:
                redSeek.setProgress(face.getSkinColorR());
                greenSeek.setProgress(face.getSkinColorG());
                blueSeek.setProgress(face.getSkinColorB());
                break;
            default:
                //dont change bar values. this shouldn't get called bc i have a default checked val
        }
        face.invalidate();
    }
}
