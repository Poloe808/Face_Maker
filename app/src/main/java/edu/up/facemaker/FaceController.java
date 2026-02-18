package edu.up.facemaker;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class FaceController implements SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    Face currentFace;
    TextView _redCount;
    TextView _greenCount;
    TextView _blueCount;
    FaceMakerModel model;
    drawView view;

    public FaceController(Face face, TextView redCount, TextView greenCount, TextView blueCount, drawView view){
        _redCount = redCount;
        _greenCount = greenCount;
        _blueCount = blueCount;
        currentFace = face;
        this.view = view;
        model = face.getModel();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.redBar){
            _redCount.setText("" + progress);
            model.redValue = progress;
            view.invalidate();
        }
        if (seekBar.getId() == R.id.greenBar){
            _greenCount.setText("" + progress);
            model.greenValue = progress;
            view.invalidate();
        }
        if (seekBar.getId() == R.id.blueBar){
            _blueCount.setText("" + progress);
            model.blueValue = progress;
            view.invalidate();
        }
        currentFace.addRGBvalues(model.redValue, model.greenValue, model.blueValue);
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        model.hairStyle = position;
        view.invalidate();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //..do nothing. :thumbsup:
    }

    @Override
    public void onClick(View v) {
        currentFace.randomize();
        view.invalidate();
    }

    @Override
    public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
        model.currentFeature = checkedId;
        currentFace.addRGBvalues(model.redValue, model.greenValue, model.blueValue);
        view.invalidate();
    }
}
