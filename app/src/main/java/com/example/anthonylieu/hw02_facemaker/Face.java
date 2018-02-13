package com.example.anthonylieu.hw02_facemaker;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by AnthonyLieu on 2/12/18.
 */

public class Face {
    private int skinRed, skinGreen, skinBlue;
    private int eyeRed, eyeGreen, eyeBlue;
    private int hairRed, hairGreen, hairBlue;
    private Paint skinColor, eyeColor, hairColor;
    private int hairStyle;

    Random gen = new Random();

    public Face(){
        randomize();
    }


    /*
     * method should ini
     */
    public void randomize() {

        skinRed = gen.nextInt(255);
        skinGreen = gen.nextInt(255);
        skinBlue = gen.nextInt(255);
        skinColor = new Paint();
        skinColor.setColor(Color.rgb(skinRed, skinGreen, skinBlue));

        eyeRed = gen.nextInt(255);
        eyeGreen = gen.nextInt(255);
        eyeBlue = gen.nextInt(255);
        eyeColor = new Paint();
        eyeColor.setColor(Color.rgb(eyeRed, eyeGreen, eyeBlue));

        hairRed = gen.nextInt(255);
        hairGreen = gen.nextInt(255);
        hairBlue = gen.nextInt(255);
        hairColor = new Paint();
        hairColor.setColor(Color.rgb(hairRed, hairGreen, hairBlue));

        hairStyle = gen.nextInt(3) + 1;
    }
}

