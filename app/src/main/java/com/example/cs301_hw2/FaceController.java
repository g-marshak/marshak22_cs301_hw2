package com.example.cs301_hw2;

import android.widget.SeekBar;

/**
 * class that controls changes in the face based on sliders/spinners/radio buttons
 */
public class FaceController implements SeekBar.OnSeekBarChangeListener{
    private Face face;

    public FaceController(Face f){
        face = f;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int seekNum, boolean fromUser) {
        //check what radiobutton is true

        //check what seekbar is being changed (rgb)

        //change r/g/b value based on that, then change overall color and invalidate to redraw
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //dont care about this
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //dont care about this either
    }
}
