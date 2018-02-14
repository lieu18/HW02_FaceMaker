package com.example.anthonylieu.hw02_facemaker;

import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.anthonylieu.hw02_facemaker.R.id.radioButtonHair;
import static com.example.anthonylieu.hw02_facemaker.R.id.seekBarRed;

public class MainActivity extends AppCompatActivity {

    private String[] hairStyles =
            {"Afro", "Flat Top", "Bowl Cut"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // https://learning.up.edu/moodle/pluginfile.php/633654/mod_resource/content/0/MainActivity.java
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

        // https://stackoverflow.com/questions/18536195/android-oncheckedchanged-for-radiogroup

        RadioGroup radioGroup =
                (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton radioButtonHair =
                (RadioButton) findViewById(R.id.radioButtonHair);
        RadioButton radioButtonEyes =
               (RadioButton) findViewById(R.id.radioButtonEyes);
        RadioButton radioButtonSkin =
                (RadioButton) findViewById(R.id.radioButtonSkin);

        // Set up controller
        MyListener aListener = new MyListener();
        aListener.addTV(textViewRed);
        aListener.addTV(textViewGreen);
        aListener.addTV(textViewBlue);
        aListener.addSB(seekBarRed);
        aListener.addSB(seekBarGreen);
        aListener.addSB(seekBarBlue);
        aListener.addRB(radioButtonHair);
        aListener.addRB(radioButtonEyes);
        aListener.addRB(radioButtonSkin);

        // Register Listener with SeekBar
        seekBarRed.setOnSeekBarChangeListener(aListener);
        seekBarGreen.setOnSeekBarChangeListener(aListener);
        seekBarBlue.setOnSeekBarChangeListener(aListener);

        radioGroup.setOnCheckedChangeListener(aListener);


    }
}