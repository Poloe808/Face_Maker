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

    public FaceController(Face face, drawView view){
        currentFace = face;
        this.view = view;
        model = face.getModel();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.redBar){
            model.seekRedValue = progress;
            view.invalidate();
        }
        if (seekBar.getId() == R.id.greenBar){
            model.seekGreenValue = progress;
            view.invalidate();
        }
        if (seekBar.getId() == R.id.blueBar){
            model.seekBlueValue = progress;
            view.invalidate();
        }
        currentFace.addRGBvalues(model.seekRedValue, model.seekGreenValue, model.seekBlueValue);
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.radioGroup){
            model.currentFeature = position;
        }
        if (parent.getId() == R.id.hairStylesSpinner){
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
        setProgressbars();
        view.invalidate();
    }

    @Override
    public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
        model.currentFeature = checkedId;
        currentFace.addRGBvalues(model.seekRedValue, model.seekGreenValue, model.seekBlueValue);
        view.invalidate();
    }

    public void setRedBar(SeekBar r){
        redbar = r;
    }
    public void setGreenBar(SeekBar r){
        greenbar = r;
    }
    public void setBluebar(SeekBar r){
        bluebar = r;
    }

    public void setProgressbars(){
        if (model.currentFeature == R.id.hairRadioButton) {
            redbar.setProgress(model.hairRedValue);
            greenbar.setProgress(model.hairGreenValue);
            bluebar.setProgress(model.hairBlueValue);
        }
        if (model.currentFeature == R.id.eyesRadioButton) {
            redbar.setProgress(model.eyeRedValue);
            greenbar.setProgress(model.eyeGreenValue);
            bluebar.setProgress(model.eyeBlueValue);
        }
        if (model.currentFeature == R.id.skinRadioButton) {
            redbar.setProgress(model.skinRedValue);
            greenbar.setProgress(model.skinGreenValue);
            bluebar.setProgress(model.skinBlueValue);
        }
    }
}
