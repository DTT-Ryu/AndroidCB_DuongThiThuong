package com.example.randomdice;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.*;
import java.util.Random;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ImageView imgDice;
    Button btnRandom;

    private void rollDice(){
        Random random = new Random();
        int number = random.nextInt(6) + 1;
        int result = getResources().getIdentifier("dice" + number, "drawable", getPackageName());
        imgDice.setImageResource(result);
    };
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        imgDice = findViewById(R.id.imgDice);
        btnRandom = findViewById(R.id.btnRandom);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }
}