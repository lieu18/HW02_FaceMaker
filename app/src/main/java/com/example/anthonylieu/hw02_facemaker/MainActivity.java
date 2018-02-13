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


        SeekBar seekBarRed =
                (SeekBar) findViewById(R.id.seekBarRed);
        seekBarRed.setOnSeekBarChangeListener(new seekBarListener());
        SeekBar seekBarGreen =
                (SeekBar) findViewById(R.id.seekBarGreen);
        seekBarGreen.setOnSeekBarChangeListener(new seekBarListener());
        SeekBar seekBarBlue =
                (SeekBar) findViewById(R.id.seekBarBlue);
        seekBarBlue.setOnSeekBarChangeListener(new seekBarListener());

        // https://stackoverflow.com/questions/18536195/android-oncheckedchanged-for-radiogroup

        RadioGroup radioGroup =
                (RadioGroup) findViewById(R.id.radioGroup);
            RadioButton radioButtonHair =
                    (RadioButton) findViewById(R.id.radioButtonHair);
            RadioButton radioButtonEyes =
                    (RadioButton) findViewById(R.id.radioButtonEyes);
            RadioButton radioButtonSkin =
                    (RadioButton) findViewById(R.id.radioButtonSkin);
            radioGroup.setOnCheckedChangeListener(new radioGroupListener());

    }

    private class seekBarListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (seekBar.getId() == R.id.seekBarRed) {
                TextView textViewRed =
                        (TextView) findViewById(R.id.textViewRed);
                textViewRed.setText("Red: " + progress);
            }
            else if (seekBar.getId() == R.id.seekBarGreen) {
                TextView textViewGreen =
                        (TextView) findViewById(R.id.textViewGreen);
                textViewGreen.setText("Green: " + progress);
            }
            else if (seekBar.getId() == R.id.seekBarBlue) {
                TextView textViewBlue =
                        (TextView) findViewById(R.id.textViewBlue);
                textViewBlue.setText("Blue: " + progress);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    private class radioGroupListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

        }
    }
}
