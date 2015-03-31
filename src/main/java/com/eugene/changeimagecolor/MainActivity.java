package com.eugene.changeimagecolor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends ActionBarActivity {
    ImageView icBike, icBus, icFerry;
    Button btnBus, btnFerry;
    EditText etColor;

    private void findViewsById() {
        icBike = (ImageView) findViewById(R.id.icBike); //Color generated through tint. Does not matter what color the image is.
        // Enter Color
        icBus = (ImageView) findViewById(R.id.icBus);
        etColor = (EditText) findViewById(R.id.etColor);
        btnBus = (Button) findViewById(R.id.btnBus);
        //Generate Random Color
        icFerry = (ImageView) findViewById(R.id.icFerry);
        btnFerry = (Button) findViewById(R.id.btnFerry);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsById();
        enterColor();
        generateRandomColor();
    }

    /*
    NOTE:
    If the image file is not white, it will multiply the color by the color entered.
    Using a white image file is best. I am currently looking for other solutions
     */
    private void enterColor() {
        btnBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    icBus.setColorFilter(Color.parseColor(etColor.getText().toString()), android.graphics.PorterDuff.Mode.MULTIPLY);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Color not in correct format", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void generateRandomColor() {
        btnFerry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icFerry.setColorFilter(randomColor(), android.graphics.PorterDuff.Mode.MULTIPLY);
            }
        });
    }

    int randomColor() {  // Generates a Random Color int
        Random r = new Random();
        int red = r.nextInt(256);
        int green = r.nextInt(256);
        int blue = r.nextInt(256);
        int randomColor = Color.rgb(red, green, blue);
        btnFerry.setText("Color: " + randomColor); // Set the button to the random int
        return randomColor;
    }
}
