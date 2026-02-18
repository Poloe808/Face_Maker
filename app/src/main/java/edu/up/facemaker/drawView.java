package edu.up.facemaker;

/* This class is where all of the face drawing is handled.
 */


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.jar.Attributes;

public class drawView extends SurfaceView {
    private Face face;
    private TextView redText;
    private TextView greenText;
    private TextView blueText;
    private SeekBar redBar;
    private SeekBar greenBar;
    private SeekBar blueBar;
    private Spinner hairSpinner;



    public drawView(Context context, AttributeSet attrs){
        //uses all the stuff from the SurfaceView class constructor
        super(context, attrs);

        //IMPORTANT.
        setWillNotDraw(false);

        //cite this later got it from https://stackoverflow.com/questions/75781174/new-version-of-jetpack-compose-androidview-malfunctions-in-earlier-android-versi
        this.setZOrderOnTop(true);

    }
    public void onDraw(Canvas canvas) {
        face.onDraw(canvas);

        hairSpinner.setSelection(face.model.hairStyle);
        /*face.model.hairRedValue;
        face.model.hairGreenValue;
        face.model.hairBlueValue;

        face.model.eyeRedValue;
        face.model.eyeGreenValue;
        face.model.eyeBlueValue;

        face.model.skinRedValue;
        face.model.skinGreenValue;
        face.model.skinBlueValue;
        */
        redText.setText("" + face.model.seekRedValue);
        greenText.setText("" + face.model.seekGreenValue);
        blueText.setText("" + face.model.seekBlueValue);

        if (face.model.currentFeature == R.id.hairRadioButton) {
            redBar.setProgress(face.model.hairRedValue);
            greenBar.setProgress(face.model.hairGreenValue);
            blueBar.setProgress(face.model.hairBlueValue);
        }
        if (face.model.currentFeature == R.id.eyesRadioButton) {
            redBar.setProgress(face.model.eyeRedValue);
            greenBar.setProgress(face.model.eyeGreenValue);
            blueBar.setProgress(face.model.eyeBlueValue);
        }
        if (face.model.currentFeature == R.id.skinRadioButton) {
            redBar.setProgress(face.model.skinRedValue);
            greenBar.setProgress(face.model.skinGreenValue);
            blueBar.setProgress(face.model.skinBlueValue);
        }
    }

    public void setFace(Face face){
        this.face = face;
    }

    public Face getFace(){
        return face;
    }

    public void setRedText(TextView v){
        redText = v;
    }

    public void setGreenText(TextView v) {
        greenText = v;
    }
    public void setBlueText(TextView v){
        blueText = v;
    }

    public void setRedBar(SeekBar b){
        redBar = b;
    }
    public void setGreenBar(SeekBar b){
        greenBar = b;
    }
    public void setBlueBar(SeekBar b){
        blueBar = b;
    }

    public void setSpinner(Spinner s){
        hairSpinner = s;
    }
}
