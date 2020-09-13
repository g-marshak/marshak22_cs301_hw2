package com.example.cs301_hw2;

import java.util.Random;

/**
 * class that describes a face (colors for skin/hair/eyes, as well as style of the hair)
 *
 * @author gabby marshak
 */

public class Face {
    //defining variables for the face
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    /**
     * constructor for the face class, randomizes values
     */
    public Face(){
        this.randomize();
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
        setSkinColor(rand.nextInt(256));
        setEyeColor(rand.nextInt(256));
        setHairColor(rand.nextInt(256));
        setHairStyle(rand.nextInt(4));
    }

    //block of setter functions for the instance variables
    public void setSkinColor(int color){
        skinColor = color;
    }

    public void setEyeColor(int color){
        eyeColor = color;
    }

    public void setHairColor(int color){
        hairColor = color;
    }

    public void setHairStyle(int color){
        hairStyle = color;
    }

    //block of getter functions for instance variables
    public int getSkinColor() {
        return skinColor;
    }

    public int getEyeColor() {
        return eyeColor;
    }

    public int getHairColor(){
        return hairColor;
    }

    public int getHairStyle() {
        return hairStyle;
    }
}
