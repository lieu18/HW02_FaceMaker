package com.example.anthonylieu.hw02_facemaker;



import android.support.annotation.IdRes;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by AnthonyLieu on 2/13/18.
 */

public class MyListener
    implements View.OnClickListener, SeekBar.OnSeekBarChangeListener,
               RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    private ArrayList<TextView> allTVs = new ArrayList<TextView>();
    private ArrayList<SeekBar> allSBs = new ArrayList<SeekBar>();
    private ArrayList<RadioButton> allRBs = new ArrayList<RadioButton>();
    private ArrayList<Spinner> allSPs = new ArrayList<Spinner>();
    private Face face;

    //private Face face; // Doesn't know how to do anything so can't do this
    public MyListener(Face myFace) {
        face = myFace;
    }



    // Methods allow more TextViews, SeekBars, RadioButtons, and Spinners to be added into thier
    // respective ArrayLists
    public void addTV (TextView newTextView) {
        allTVs.add(newTextView);
    }
    public void addSB (SeekBar newSeekBar) {
        allSBs.add(newSeekBar);
    }
    public void addRB (RadioButton newRadioButton) {
        allRBs.add(newRadioButton);
    }
    public void addSP (Spinner newSpinner) {
        allSPs.add(newSpinner);
    }

    // Button method
    // This button creates a new random face every time it is clicked
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonRandomFace) {
            face.randomize();
        }
        for (SeekBar sb : allSBs) {
            if (allRBs.get(0).isChecked()) {
                if (sb.getId() == R.id.seekBarRed) {
                    sb.setProgress(face.hairRed);
                }
                else if (sb.getId() == R.id.seekBarGreen) {
                    sb.setProgress(face.hairGreen);
                }
                else if (sb.getId() == R.id.seekBarBlue) {
                    sb.setProgress(face.hairBlue);
                }
            }
            else if (allRBs.get(1).isChecked()) {
                if (sb.getId() == R.id.seekBarRed) {
                    sb.setProgress(face.eyeRed);
                }
                else if (sb.getId() == R.id.seekBarGreen) {
                    sb.setProgress(face.eyeGreen);
                }
                else if (sb.getId() == R.id.seekBarBlue) {
                    sb.setProgress(face.eyeBlue);
                }
            }
            else if (allRBs.get(2).isChecked()) {
                if (sb.getId() == R.id.seekBarRed) {
                    sb.setProgress(face.skinRed);
                }
                else if (sb.getId() == R.id.seekBarGreen) {
                    sb.setProgress(face.skinGreen);
                }
                else if (sb.getId() == R.id.seekBarBlue) {
                    sb.setProgress(face.skinBlue);
                }
            }
        }

        face.invalidate();
    }

    /*
    External Citation
        Date: February 13, 2018
        Problem: Did not know or understand how this listener works
        Resource: https://stackoverflow.com/questions/42502055
                  /how-to-check-which-radio-button-of-a-radio-group-is-selected-android/42502234
        Solution: I used the example here to implement this listener
     */

    // RadioGroup Method
    // This method should allow the user to toggle through the 3 different features and their settings
    // The seekbars for the RGB components should change depending on which button is clicked
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        int checkedRadioButton = group.getCheckedRadioButtonId();
        if (checkedRadioButton == R.id.radioButtonHair) { // Checks which radio button is checked
            for (SeekBar sb : allSBs) { // Determine which seekbar should display which value
                if (sb.getId() == R.id.seekBarRed) {
                    sb.setProgress(face.hairRed);
                }
                else if (sb.getId() == R.id.seekBarGreen) {
                    sb.setProgress(face.hairGreen);
                }
                else if (sb.getId() == R.id.seekBarBlue) {
                    sb.setProgress(face.hairBlue);
                }
            }
        }
        else if (checkedRadioButton == R.id.radioButtonEyes) {
            for (SeekBar sb : allSBs) {
                if (sb.getId() == R.id.seekBarRed) {
                    sb.setProgress(face.eyeRed);
                }
                else if (sb.getId() == R.id.seekBarGreen) {
                    sb.setProgress(face.eyeGreen);
                }
                else if (sb.getId() == R.id.seekBarBlue) {
                    sb.setProgress(face.eyeBlue);
                }
            }
        }
        else if (checkedRadioButton == R.id.radioButtonSkin) {
            for (SeekBar sb : allSBs) {
                if (sb.getId() == R.id.seekBarRed) {
                    sb.setProgress(face.skinRed);
                }
                else if (sb.getId() == R.id.seekBarGreen) {
                    sb.setProgress(face.skinGreen);
                }
                else if (sb.getId() == R.id.seekBarBlue) {
                    sb.setProgress(face.skinBlue);
                }
            }
        }
        face.invalidate();
    }

    // SeekBar Methods
    // This controls the RGB values of the different features
    // This should allow the user to freely change the color of the face to thier liking

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int curSeekBarId = seekBar.getId();
        for (TextView tv : allTVs) {
            if ((curSeekBarId == R.id.seekBarRed) && (tv.getId() == R.id.textViewRed)) {
                seekBar.setProgress(progress); // Moves seekbar to correct location
                tv.setText("Red: " + progress); // Updates the TextView to the corresponding seekbar

                if (allRBs.get(0).isChecked()) { // Checks for which RadioButton is click
                    face.hairRed = progress;     // adjust the RGB components as the seekbar moves
                }
                else if (allRBs.get(1).isChecked()) {
                    face.eyeRed = progress;
                }
                else if (allRBs.get(2).isChecked()) {
                    face.skinRed = progress;
                }
            }
            else if ((curSeekBarId == R.id.seekBarGreen) && (tv.getId() == R.id.textViewGreen)) {
                seekBar.setProgress(progress);
                tv.setText("Green: " + progress);

                if (allRBs.get(0).isChecked()) {
                    face.hairGreen = progress;
                }
                else if (allRBs.get(1).isChecked()) {
                    face.eyeGreen = progress;
                }
                else if (allRBs.get(2).isChecked()) {
                    face.skinGreen = progress;
                }
            }
            else if ((curSeekBarId == R.id.seekBarBlue) && (tv.getId() == R.id.textViewBlue)) {
                seekBar.setProgress(progress);
                tv.setText("Blue: " + progress);

                if (allRBs.get(0).isChecked()) {
                    face.hairBlue = progress;
                }
                else if (allRBs.get(1).isChecked()) {
                    face.eyeBlue = progress;
                }
                else if (allRBs.get(2).isChecked()) {
                    face.skinBlue = progress;
                }
            }
        }
        face.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // Do Nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // Do Nothing
    }

    // Spinner Methods
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // This sets the hairstyle based on the position of the spinner
        face.hairStyle = position;
        face.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }
}
