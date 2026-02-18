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

import java.util.jar.Attributes;

public class drawView extends SurfaceView {
    private Face face;

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
    }

    public void setFace(Face face){
        this.face = face;
    }

    public Face getFace(){
        return face;
    }
}
