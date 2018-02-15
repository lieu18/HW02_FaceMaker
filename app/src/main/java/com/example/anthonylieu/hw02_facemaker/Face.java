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

    public static Paint skinColor, eyeColor, hairColor, White, Black;

    private SurfaceView sv;

    public int skinRed, skinGreen, skinBlue;
    public int eyeRed, eyeGreen, eyeBlue;
    public int hairRed, hairGreen, hairBlue;

    private int redSkin, greenSkin, blueSkin, redEye, greenEye, blueEye, redHair, greenHair, blueHair;

    public static int hairStyle;

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
        skinColor.setColor(Color.rgb(redSkin, greenSkin, blueSkin));

        eyeColor = new Paint();
        eyeColor.setColor(Color.rgb(redEye, greenEye, blueEye));

        hairColor = new Paint();
        hairColor.setColor(Color.rgb(redHair, greenHair, blueHair));

        White = new Paint();
        White.setColor(Color.WHITE);

        Black = new Paint();
        Black.setColor(Color.BLACK);

        sv = (SurfaceView) findViewById(R.id.surfaceView);
    }

    /*
     * randomize method to randomize the color of the skin, eyes, and hair
     */
    public void randomize() {

        redSkin = gen.nextInt(255);
        greenSkin = gen.nextInt(255);
        blueSkin = gen.nextInt(255);

        redEye = gen.nextInt(255);
        greenEye = gen.nextInt(255);
        blueEye = gen.nextInt(255);

        redHair = gen.nextInt(255);
        greenHair = gen.nextInt(255);
        blueHair = gen.nextInt(255);

        hairStyle = gen.nextInt(3) + 1;

        skinRed = redSkin;
        skinGreen = greenSkin;
        skinBlue = blueSkin;

        eyeRed = redEye;
        eyeGreen = greenEye;
        eyeBlue = blueEye;

        hairRed = redHair;
        hairGreen = greenHair;
        hairBlue = blueHair;


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
        canvas.drawCircle(700f, 750f, 50f, Black); // left pupil
        canvas.drawCircle(1100f, 750f, 50f, Black); // right pupil
        canvas.drawArc(700f, 1050f, 1100f, 1150, 0f, 180f, true, White); // mouth
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) // Required for drawArc
    public void onDraw(Canvas canvas) {

        compareRGB();

        if (hairStyle == 1) {
            canvas.drawRect(400f, 100f, 1400f, 900f, hairColor); // Flat Top Hair
            drawHead(canvas);

        }
        else if (hairStyle == 2) {
            canvas.drawCircle(900f, 700f, 600f, hairColor); // Afro Hair
            drawHead(canvas);

        }
        else if (hairStyle == 3) {
            drawHead(canvas);
            canvas.drawArc(440f, 400f, 1360f, 1000f, 180f, 180f, true, hairColor); // Bowl Cut

        }
        else {
            drawHead(canvas);

        }
    }

    public void compareRGB () {
        if (redHair != hairRed) {
            redHair = hairRed;
            hairColor.setColor(Color.rgb(redHair, greenHair, blueHair));
        }
        if (greenHair != hairGreen) {
            greenHair = hairGreen;
            hairColor.setColor(Color.rgb(redHair, greenHair, blueHair));
        }
        if (blueHair != hairBlue) {
            blueHair = hairBlue;
            hairColor.setColor(Color.rgb(redHair, greenHair, blueHair));
        }
        if (redEye != eyeRed) {
            redEye = eyeRed;
            eyeColor.setColor(Color.rgb(redEye, greenEye, blueEye));
        }
        if (greenEye != eyeGreen) {
            greenEye = eyeGreen;
            eyeColor.setColor(Color.rgb(redEye, greenEye, blueEye));
        }
        if (blueEye != eyeBlue) {
            blueEye = eyeBlue;
            eyeColor.setColor(Color.rgb(redEye, greenEye, blueEye));
        }
        if (redSkin != skinRed) {
            redSkin = skinRed;
            skinColor.setColor(Color.rgb(redSkin, greenSkin, blueSkin));
        }
        if (greenSkin != skinGreen) {
            greenSkin = skinGreen;
            skinColor.setColor(Color.rgb(redSkin, greenSkin, blueSkin));
        }
        if (blueSkin != skinBlue) {
            blueSkin = skinBlue;
            skinColor.setColor(Color.rgb(redSkin, greenSkin, blueSkin));
        }
    }
}

