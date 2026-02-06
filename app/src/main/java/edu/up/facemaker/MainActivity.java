package edu.up.facemaker;

import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.ArrayAdapter;
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
    String[] hairStyles = {"Bowl Cut", "Pigtails", "Messy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creates a reference to the spinner in activity_main and puts values inside it.
        Spinner hairStylesSpinner = findViewById(R.id.hairStylesSpinner);
        ArrayAdapter<String> styleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, this.hairStyles);
        hairStylesSpinner.setAdapter(styleAdapter);
        }
    }
