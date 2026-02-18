package edu.up.facemaker;

import static java.util.HexFormat.fromHexDigit;
import static java.util.HexFormat.fromHexDigits;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import 	java.util.Random;
import 	java.util.HexFormat;

/**
 * @author Logan Ortogero
 */

//This would be the MODEL in the MVC
//...with drawing functionality...

public class Face {

    //These are the instance variables for the Face Class
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    //Identifies which hair style the face has.
    private int hairStyle;

    FaceMakerModel model;

    Paint currentColor = new Paint();

    //this is the random variable used to access random functionality.
    Random rng = new Random();

    public Face(FaceMakerModel model){
        //initializes all the variables to a random value when a face object is created.
        //Hairstyles have a current max of three hairstyles to choose from. This may change
        randomize();
        this.model = model;
    }

    //randomizes the number between 0 and the number passed in.
    public void randomize(){
        skinColor = rng.nextInt(0x00FFFFFF) + 0xFF000000;
        eyeColor = rng.nextInt(0x00FFFFFF) + 0xFF000000;
        hairColor = rng.nextInt(0x00FFFFFF) + 0xFF000000;
        hairStyle = rng.nextInt(3);
    }

    //Currently empty for the time being.
    public void onDraw(Canvas canvas){
        currentColor.setColor(hairColor);
        canvas.drawCircle(500, 500, 200, currentColor);
        currentColor.setColor(hairColor);
        if (hairStyle == 0){
            //draw Bowl Cut
            canvas.drawText("bowl", 10, 10, currentColor);
        }
        else if (hairStyle == 1)
        {
            //draw pigtails
            canvas.drawText("pigtails", 10, 10, currentColor);
        }
        else if (hairStyle == 2)
        {
            //draw messy
            canvas.drawText("messy", 10, 10, currentColor);
        }
        currentColor.setColor(eyeColor);
        canvas.drawCircle(400, 450, 30, currentColor);
        canvas.drawCircle(600, 450, 30, currentColor);
    }

    public FaceMakerModel getModel(){
        return model;
    }

    //Credit later, from:https://stackoverflow.com/questions/3607858/convert-a-rgb-color-value-to-a-hexadecimal-string THANK YOU :clasped_hands:
    public void addRGBvalues(int red, int green, int blue){
        String hex = String.format("FF%02x%02x%02x", red, green, blue);
        int hexInt = fromHexDigits(hex);

        if(model.currentFeature == 0){
            hairColor = hexInt;
        }
        if(model.currentFeature == 1){
            eyeColor = hexInt;
        }
        if(model.currentFeature == 2){
            skinColor = hexInt;
        }
    }
}
