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
import android.widget.TextView;

import java.util.jar.Attributes;

public class drawView extends SurfaceView {
    private Face face;
    private TextView redText;
    private TextView greenText;
    private TextView blueText;


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
        redText.setText("" + face.model.seekRedValue);
        greenText.setText("" + face.model.seekGreenValue);
        blueText.setText("" + face.model.seekBlueValue);
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

}
