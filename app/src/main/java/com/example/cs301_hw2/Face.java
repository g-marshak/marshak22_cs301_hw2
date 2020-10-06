package com.example.cs301_hw2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

import static android.graphics.Color.rgb;

/**
 * class that describes a face (colors for skin/hair/eyes, as well as style of the hair)
 * (kind of combining model/view for size and convenience)
 * @author gabby marshak
 */

public class Face extends SurfaceView {
    //defining variables for the face
    private int skinColor;
    private int skinColorR;
    private int skinColorG;
    private int skinColorB;

    private int eyeColor;
    private int eyeColorR;
    private int eyeColorG;
    private int eyeColorB;

    private int hairColor;
    private int hairColorR;
    private int hairColorG;
    private int hairColorB;

    private int hairStyle;

    //set up paints for face/eyes/hair
    Paint skinPaint = new Paint();
    Paint eyeIrisPaint = new Paint();
    Paint eyeScleraPaint = new Paint();
    Paint eyePupilPaint = new Paint();
    Paint hairPaint = new Paint();

    /**
     * constructor for the face class, randomizes values
     */
    /**
     External Citation
     Date: 10/6/2020
     Problem: got confused about how to set up a class for drawing due to not having done the setup itself before
     Resource: example code from class
     Solution: looked at how demo set up Shapes class
     */
    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        this.randomize();

        //init paints based on defining variables (or hardcoded colors)
        skinPaint.setColor(getSkinColor());
        eyeIrisPaint.setColor(getEyeColor());
        eyeScleraPaint.setColor(Color.WHITE);
        eyePupilPaint.setColor(Color.BLACK);
        hairPaint.setColor(getHairColor());
    }

    /**
     * randomizes the colors of the skin/eyes/hair, and the style of the hair
     *
     * @return void function
     */
    public void randomize(){
        /**
         External Citation
         Date: 9/11/2020
         Problem: needed a refresher on how randomization in java works (how to set bounds in particular)
         Resource: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Random.html
         Solution: looked at the documentation (not sure if i need to cite every time i need to look at documentation or not?)
         */
        Random rand = new Random();
        setSkinColorR(rand.nextInt(256));
        setSkinColorG(rand.nextInt(256));
        setSkinColorB(rand.nextInt(256));
        setSkinColor(getSkinColorR(), getSkinColorG(), getSkinColorB());

        setEyeColorR(rand.nextInt(256));
        setEyeColorG(rand.nextInt(256));
        setEyeColorB(rand.nextInt(256));
        setEyeColor(getEyeColorR(), getEyeColorG(), getEyeColorB());

        setHairColorR(rand.nextInt(256));
        setHairColorG(rand.nextInt(256));
        setHairColorB(rand.nextInt(256));
        setHairColor(getHairColorR(), getHairColorG(), getHairColorB());

        setHairStyle(rand.nextInt(4));
    }

    //block of setter functions for the instance variables
    public void setSkinColor(int r, int g, int b){
        skinColor = rgb(r, g, b);
    }
    public void setSkinColorR(int color){
        skinColorR = color;
    }
    public void setSkinColorG(int color){
        skinColorG = color;
    }
    public void setSkinColorB(int color){
        skinColorB = color;
    }

    public void setEyeColor(int r, int g, int b){
        eyeColor = rgb(r, g, b);
    }
    public void setEyeColorR(int color){
        eyeColorR = color;
    }
    public void setEyeColorG(int color){
        eyeColorG = color;
    }
    public void setEyeColorB(int color){
        eyeColorB = color;
    }

    public void setHairColor(int r, int g, int b){
        hairColor = rgb(r, g, b);
    }
    public void setHairColorR(int color){ hairColorR = color; }
    public void setHairColorG(int color){ hairColorG = color; }
    public void setHairColorB(int color){ hairColorB = color; }

    public void setHairStyle(int style){
        hairStyle = style;
    }

    //block of getter functions for instance variables
    public int getSkinColor() {
        return skinColor;
    }
    public int getSkinColorR() { return skinColorR; }
    public int getSkinColorG() { return skinColorG; }
    public int getSkinColorB() { return skinColorB; }

    public int getEyeColor() {
        return eyeColor;
    }
    public int getEyeColorR() { return eyeColorR; }
    public int getEyeColorG() {
        return eyeColorG;
    }
    public int getEyeColorB() {
        return eyeColorB;
    }

    public int getHairColor(){
        return hairColor;
    }
    public int getHairColorR(){
        return hairColorR;
    }
    public int getHairColorG(){
        return hairColorG;
    }
    public int getHairColorB(){
        return hairColorB;
    }

    public int getHairStyle() {
        return hairStyle;
    }

    /**
     * method to draw the face itself on a given canvas
     * @param canvas
     */
    @Override
    public void onDraw(Canvas canvas){
        drawFace(canvas, skinPaint);
        //drawEyes(canvas, eyeScleraPaint);
    }

    //helper methods for drawing the face
    public void drawFace(Canvas canvas, Paint skin){
        //draw one circle at the center of the screen, then one on either side for ears
        canvas.drawCircle(750, 700, 300, skinPaint);
        canvas.drawCircle(450, 700, 100, skinPaint);
        canvas.drawCircle(1050, 700, 100, skinPaint);
    }

    public void drawEyes(Canvas canvas, Paint eyes){
        //canvas.drawCircle(550, 650, 30, eyeScleraPaint);
        //canvas.drawCircle(950, 650, 30, eyeScleraPaint);
    }

    public void drawHair(Canvas canvas, Paint hair){
        //case statement to determine what hairstyle to draw
    }
}
