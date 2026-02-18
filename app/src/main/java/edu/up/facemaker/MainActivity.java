package edu.up.facemaker;

import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * @author Logan Ortogero
 */

public class MainActivity extends AppCompatActivity {

    //A set of hair styles for the spinner below
    String[] hairStyles = {"Bowl Cut", "Pigtails", "Broccoli Shaped"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creates a reference to the spinner in activity_main and puts values inside it.
        Spinner hairStylesSpinner = findViewById(R.id.hairStylesSpinner);
        ArrayAdapter<String> styleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, this.hairStyles);
        hairStylesSpinner.setAdapter(styleAdapter);

        //create the faceMakerModel
        FaceMakerModel model = new FaceMakerModel();
        //Make a face object! passing in the FMM
        Face face = new Face(model);
        drawView _drawView = findViewById(R.id.faceDrawingSpace);

        _drawView.setRedText(findViewById(R.id.redValue));
        _drawView.setGreenText(findViewById(R.id.greenValue));
        _drawView.setBlueText(findViewById(R.id.blueValue));

        _drawView.setFace(face);

        //create the controller and pass the model in
        FaceController ctrl = new FaceController(face, _drawView);

        SeekBar redBar = findViewById(R.id.redBar);
        redBar.setOnSeekBarChangeListener(ctrl);
        ctrl.setRedBar(redBar);


        SeekBar greenBar = findViewById(R.id.greenBar);
        greenBar.setOnSeekBarChangeListener(ctrl);
        ctrl.setGreenBar(greenBar);

        SeekBar blueBar = findViewById(R.id.blueBar);
        blueBar.setOnSeekBarChangeListener(ctrl);
        ctrl.setBluebar(blueBar);

        Button randButton = findViewById(R.id.randomFaceButton);
        randButton.setOnClickListener(ctrl);

        RadioGroup featureGroup = findViewById(R.id.radioGroup);
        featureGroup.setOnCheckedChangeListener(ctrl);

        Spinner hairStyleSpinner = findViewById(R.id.hairStylesSpinner);
        hairStyleSpinner.setOnItemSelectedListener(ctrl);
        }
    }
