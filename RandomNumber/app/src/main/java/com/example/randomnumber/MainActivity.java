package com.example.randomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;
import java.util.Random;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView txtNumber;
    Button btnRandom;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber = findViewById((R.id.txtNumber));
        btnRandom = findViewById(R.id.btnRandom);
        random = new Random();

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = random.nextInt(100) + 1;
                txtNumber.setText(String.valueOf(number));
            }
        });
    }
}