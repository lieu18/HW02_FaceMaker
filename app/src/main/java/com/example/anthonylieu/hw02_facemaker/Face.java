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


public class Face extends SurfaceView {

    public static Paint skinColor, eyeColor, hairColor, White;

    private static SurfaceView sv;

    public static int skinRed, skinGreen, skinBlue;
    public static int eyeRed, eyeGreen, eyeBlue;
    public static int hairRed, hairGreen, hairBlue;

    public static int hairStyle;

    private static Random gen = new Random();

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
    public static void randomize() {

        skinRed = gen.nextInt(255);
        skinGreen = gen.nextInt(255);
        skinBlue = gen.nextInt(255);

        eyeRed = gen.nextInt(255);
        eyeGreen = gen.nextInt(255);
        eyeBlue = gen.nextInt(255);

        hairRed = gen.nextInt(255);
        hairGreen = gen.nextInt(255);
        hairBlue = gen.nextInt(255);

        hairStyle = gen.nextInt(2);

    }

    /*
    External Citation
        Date: February 12, 2018
        Problem: Did not know the paint calls for canvas
        Resource: https://developer.android.com/reference/android/graphics/Canvas.html
        Solution: I read through the documentation and tested out a variety of function calls
     */

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) // Required for drawArc
    public void drawHead(Canvas canvas) {
        // Gives me the bald face
        canvas.drawCircle(900f, 900f, 500f, skinColor); // face
        canvas.drawCircle(700f, 750f, 100f, White); // left eye whites
        canvas.drawCircle(1100f, 750f, 100f, White); // right eye whites
        canvas.drawCircle(700f, 750f, 70f, eyeColor); // left eye
        canvas.drawCircle(1100f, 750f, 70f, eyeColor); // right eye
        canvas.drawArc(700f, 1050f, 1100f, 1150, 0f, 180f, true, White); // mouth
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) // Required for drawArc
    public void onDraw(Canvas canvas) {

        if (hairStyle == 0) {
            canvas.drawRect(400f, 100f, 1400f, 900f, hairColor); // Flat Top Hair
            drawHead(canvas);
        }
        else if (hairStyle == 1) {
            canvas.drawCircle(900f, 700f, 600f, hairColor); // Afro Hair
            drawHead(canvas);
        }
        else {
            drawHead(canvas);
            canvas.drawArc(440f, 400f, 1360f, 1000f, 180f, 180f, true, hairColor); // Bowl Cut
        }
    }
}

