package edu.up.facemaker;

import android.graphics.Canvas;
import 	java.util.Random;

/**
 * @author Logan Ortogero
 */

public class Face {

    //These are the instance variables for the Face Class
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    //Identifies which hair style the face has.
    private int hairStyle;

    //this is the random variable used to access random functionality.
    Random rng = new Random();

    public Face(){
        //initializes all the variables to a random value when a face object is created.
        //Hairstyles have a current max of three hairstyles to choose from. This may change.
        skinColor = randomize(255);
        eyeColor = randomize(255);
        hairColor = randomize(255);
        hairStyle = randomize(3);
    }

    //randomizes the number between 0 and the number passed in.
    private int randomize(int max){
        return rng.nextInt(max);
    }

    //Currently empty for the time being.
    private void onDraw(Canvas face){

    }

}
