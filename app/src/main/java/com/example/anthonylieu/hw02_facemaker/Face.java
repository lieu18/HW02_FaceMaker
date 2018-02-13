package com.example.anthonylieu.hw02_facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by AnthonyLieu on 2/12/18.
 */

// https://learning.up.edu/moodle/pluginfile.php/635566/mod_resource/content/0/MyArtwork.java
public class Face extends SurfaceView {

    private Paint skinColor, eyeColor, hairColor;

    private SurfaceView sv;

    private int skinRed, skinGreen, skinBlue;
    private int eyeRed, eyeGreen, eyeBlue;
    private int hairRed, hairGreen, hairBlue;

    private int hairStyle;

    private Random gen = new Random();

    public Face(Context context) {
        super(context);
        faceInit();
    }

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        faceInit();
    }

    public Face(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        faceInit();
    }

    public void faceInit() {
        setWillNotDraw(false);
        randomize();
        sv = (SurfaceView) findViewById(R.id.surfaceView);
    }

    /*
     * randomize method to randomize the color of the skin, eyes, and hair
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


    public void onDraw(Canvas canvas) {

        //canvas.drawRect(400f, 100f, 1400f, 900f, hairColor); // Flat Top Hair
        //canvas.drawCircle(900f, 700f, 600f, hairColor); // Afro Hair

        canvas.drawCircle(900f, 900f, 500f, skinColor);
    }
}

