package com.example.anthonylieu.hw02_facemaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author Anthony Lieu
 * MainActivity.Java is where the IDs are set into their widget declarations
 * This also utilizes MyListener.java to provide functionality to the app
 */

public class MainActivity extends AppCompatActivity {

    private String[] hairStyles =
            {"Choose a Hair Style", "Flat Top", "Afro", "Bowl Cut"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* External Citation
         *      Date: February 14, 2018
         *      Problem: Could not call invalidate() command to change the surfaceView
         *      Resource: Noah Davis -> Andrew Nuxoll
         *      Solution: I had issues with bringing in the Face class from Face.java into MainActivity
         *                and using invalidate.
         *                This uses the original view that is first initialized and "re draws" the view
         */

        final Face face = (Face)findViewById(R.id.surfaceView);

        /*
        External Citation
            Date: February 12, 2018
            Problem: Did not know where to start for spinners
            Resource: https://learning.up.edu/moodle/pluginfile.php/633654
                      /mod_resource/content/0/MainActivity.java
            Solution: I used the examples in class start my spinner
         */

        ArrayAdapter<String> spinAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, hairStyles);
        Spinner spinnerHairStyle =
                (Spinner) findViewById(R.id.spinnerHairStyle);
        spinnerHairStyle.setAdapter(spinAdapter);


        TextView textViewRed =
                (TextView) findViewById(R.id.textViewRed);
        TextView textViewGreen =
                (TextView) findViewById(R.id.textViewGreen);
        TextView textViewBlue =
                (TextView) findViewById(R.id.textViewBlue);


        SeekBar seekBarRed =
                (SeekBar) findViewById(R.id.seekBarRed);
        seekBarRed.setMax(255);
        SeekBar seekBarGreen =
                (SeekBar) findViewById(R.id.seekBarGreen);
        seekBarGreen.setMax(255);
        SeekBar seekBarBlue =
                (SeekBar) findViewById(R.id.seekBarBlue);
        seekBarBlue.setMax(255);

        /*
        External Citation
            Date: February 12, 2018
            Problem: Did not know about Radio Group
                     Could not set Radio Buttons to only have one button clicked at a time
            Resource: https://stackoverflow.com/questions/18536195/android-oncheckedchanged
                      -for-radiogroup
            Solution: I used this example and based by declarations on this.
         */

        RadioGroup radioGroup =
                (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton radioButtonHair =
                (RadioButton) findViewById(R.id.radioButtonHair);
        RadioButton radioButtonEyes =
               (RadioButton) findViewById(R.id.radioButtonEyes);
        RadioButton radioButtonSkin =
                (RadioButton) findViewById(R.id.radioButtonSkin);

        Button buttonRandomFace =
                (Button) findViewById(R.id.buttonRandomFace);



        // Set up controller
        MyListener aListener = new MyListener(face);
        aListener.addTV(textViewRed);
        aListener.addTV(textViewGreen);
        aListener.addTV(textViewBlue);
        aListener.addSB(seekBarRed);
        aListener.addSB(seekBarGreen);
        aListener.addSB(seekBarBlue);
        aListener.addRB(radioButtonHair);
        aListener.addRB(radioButtonEyes);
        aListener.addRB(radioButtonSkin);
        aListener.addSP(spinnerHairStyle);

        /*
        External Citation
            Date: February 13, 2018
            Problem: Did not know why breakpoints in my Listener.java fell through
            Resource: https://learning.up.edu/moodle/pluginfile.php/638764
                      /mod_resource/content/1/MainActivity.java
            Solution: Remembered step 3 after staring at the resource for at least 5 minutes
         */

        // Register Listeners for the different components
        seekBarRed.setOnSeekBarChangeListener(aListener);
        seekBarGreen.setOnSeekBarChangeListener(aListener);
        seekBarBlue.setOnSeekBarChangeListener(aListener);

        radioGroup.setOnCheckedChangeListener(aListener);

        buttonRandomFace.setOnClickListener(aListener);

        spinnerHairStyle.setOnItemSelectedListener(aListener);

    }
}