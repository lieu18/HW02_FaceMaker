package com.example.anthonylieu.hw02_facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.RequiresApi;
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

    private Paint skinColor, eyeColor, hairColor, White;

    private SurfaceView sv;

    public static int skinRed, skinGreen, skinBlue;
    public static int eyeRed, eyeGreen, eyeBlue;
    public static int hairRed, hairGreen, hairBlue;

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

        skinColor = new Paint();
        skinColor.setColor(Color.rgb(skinRed, skinGreen, skinBlue));

        eyeColor = new Paint();
        eyeColor.setColor(Color.rgb(eyeRed, eyeGreen, eyeBlue));

        hairColor = new Paint();
        hairColor.setColor(Color.rgb(hairRed, hairGreen, hairBlue));

        White = new Paint();
        White.setColor(Color.WHITE);

        sv = (SurfaceView) findViewById(R.id.surfaceView);
    }

    /*
     * randomize method to randomize the color of the skin, eyes, and hair
     */
    public void randomize() {

        skinRed = gen.nextInt(255);
        skinGreen = gen.nextInt(255);
        skinBlue = gen.nextInt(255);

        eyeRed = gen.nextInt(255);
        eyeGreen = gen.nextInt(255);
        eyeBlue = gen.nextInt(255);

        hairRed = gen.nextInt(255);
        hairGreen = gen.nextInt(255);
        hairBlue = gen.nextInt(255);

    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) // Required to use drawArc
    public void onDraw(Canvas canvas) {

        //canvas.drawRect(400f, 100f, 1400f, 900f, hairColor); // Flat Top Hair
        canvas.drawCircle(900f, 700f, 600f, hairColor); // Afro Hair


        // Gives me the bald face
        canvas.drawCircle(900f, 900f, 500f, skinColor); // face
        canvas.drawCircle(700f, 750f, 100f, White); // left eye whites
        canvas.drawCircle(1100f, 750f, 100f, White); // right eye whites
        canvas.drawCircle(700f, 750f, 70f, eyeColor); // left eye
        canvas.drawCircle(1100f, 750f, 70f, eyeColor); // right eye
        canvas.drawArc(700f,1050f, 1100f, 1150, 0f, 180f, true, White); // mouth



        //canvas.drawArc(440f, 400f, 1360f, 1000f, 180f, 180f, true, hairColor); // Bowl Cut

    }
}

