package com.example.anthonylieu.hw02_facemaker;


import android.support.annotation.IdRes;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AnthonyLieu on 2/13/18.
 */

public class MyListener
    implements View.OnClickListener, SeekBar.OnSeekBarChangeListener,
               RadioGroup.OnCheckedChangeListener {

    private ArrayList<TextView> allTVs = new ArrayList<TextView>();
    private ArrayList<SeekBar> allSBs = new ArrayList<SeekBar>();
    private ArrayList<RadioButton> allRBs = new ArrayList<RadioButton>();

    public void addTV (TextView newTextView) {
        allTVs.add(newTextView);
    }
    public void addSB (SeekBar newSeekBar) {
        allSBs.add(newSeekBar);
    }
    public void addRB (RadioButton newRadioButton) {
        allRBs.add(newRadioButton);
    }

    @Override
    public void onClick(View v) {

    }

    // https://stackoverflow.com/questions/42502055/how-to-check-which-radio-button-of-a-radio-group-is-selected-android/42502234

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        int checkedRadioButton = group.getCheckedRadioButtonId();
        if (checkedRadioButton == R.id.radioButtonHair) {
            for (SeekBar sb : allSBs) {
                if (sb.getId() == R.id.seekBarRed) {
                    sb.setProgress(Face.hairRed);
                }
                else if (sb.getId() == R.id.seekBarGreen) {
                    sb.setProgress(Face.hairGreen);
                }
                else if (sb.getId() == R.id.seekBarBlue) {
                    sb.setProgress(Face.hairBlue);
                }
            }
        }
        else if (checkedRadioButton == R.id.radioButtonEyes) {
            for (SeekBar sb : allSBs) {
                if (sb.getId() == R.id.seekBarRed) {
                    sb.setProgress(Face.eyeRed);
                }
                else if (sb.getId() == R.id.seekBarGreen) {
                    sb.setProgress(Face.eyeGreen);
                }
                else if (sb.getId() == R.id.seekBarBlue) {
                    sb.setProgress(Face.eyeBlue);
                }
            }
        }
        else if (checkedRadioButton == R.id.radioButtonSkin) {
            for (SeekBar sb : allSBs) {
                if (sb.getId() == R.id.seekBarRed) {
                    sb.setProgress(Face.skinRed);
                }
                else if (sb.getId() == R.id.seekBarGreen) {
                    sb.setProgress(Face.skinGreen);
                }
                else if (sb.getId() == R.id.seekBarBlue) {
                    sb.setProgress(Face.skinBlue);
                }
            }
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int curSeekBarId = seekBar.getId();
        for (TextView tv : allTVs) {
            if ((curSeekBarId == R.id.seekBarRed) && (tv.getId() == R.id.textViewRed)) {
                seekBar.setProgress(progress);
                tv.setText("Red: " + progress);
            }
            else if ((curSeekBarId == R.id.seekBarGreen) && (tv.getId() == R.id.textViewGreen)) {
                seekBar.setProgress(progress);
                tv.setText("Green: " + progress);
            }
            else if ((curSeekBarId == R.id.seekBarBlue) && (tv.getId() == R.id.textViewBlue)) {
                seekBar.setProgress(progress);
                tv.setText("Blue: " + progress);
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // Do Nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // Do Nothing
    }
}
