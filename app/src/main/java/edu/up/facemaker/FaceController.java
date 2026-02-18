package edu.up.facemaker;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class FaceController implements SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener,
        View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    Face currentFace;
    FaceMakerModel model;
    drawView view;
    SeekBar redbar;
    SeekBar greenbar;
    SeekBar bluebar;
    Spinner spinner;

    public FaceController(Face face, drawView view) {
        currentFace = face;
        this.view = view;
        model = face.getModel();


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.redBar) {
            model.seekRedValue = progress;
            if (model.currentFeature == R.id.hairRadioButton) {
                model.hairRedValue = progress;
            }
            if (model.currentFeature == R.id.eyesRadioButton) {
                model.eyeRedValue = progress;
            }
            if (model.currentFeature == R.id.skinRadioButton) {
                model.skinRedValue = progress;
            }
        }
        if (seekBar.getId() == R.id.greenBar) {
            model.seekGreenValue = progress;
            if (model.currentFeature == R.id.hairRadioButton) {
                model.hairGreenValue = progress;
            }
            if (model.currentFeature == R.id.eyesRadioButton) {
                model.eyeGreenValue = progress;
            }
            if (model.currentFeature == R.id.skinRadioButton) {
                model.skinGreenValue = progress;
            }
        }
        if (seekBar.getId() == R.id.blueBar) {
            model.seekBlueValue = progress;
            if (model.currentFeature == R.id.hairRadioButton) {
                model.hairBlueValue = progress;
            }
            if (model.currentFeature == R.id.eyesRadioButton) {
                model.eyeBlueValue = progress;
            }
            if (model.currentFeature == R.id.skinRadioButton) {
                model.skinBlueValue = progress;
            }
        }
        currentFace.addRGBvalues(model.seekRedValue, model.seekGreenValue, model.seekBlueValue);
        view.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.radioGroup) {
            model.currentFeature = position;
        }
        if (parent.getId() == R.id.hairStylesSpinner) {
            model.hairStyle = position;
        }
        this.view.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //..do nothing. :thumbsup:
    }

    @Override
    public void onClick(View v) {
        currentFace.randomize();
        currentFace.randomizeSetter();
        //setProgressbars();
        view.invalidate();
    }

    @Override
    public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
        model.currentFeature = checkedId;

        view.invalidate();
    }
}
