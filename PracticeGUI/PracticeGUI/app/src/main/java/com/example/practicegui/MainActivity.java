package com.example.practicegui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnEx1, btnEx2, btnEx4, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setTitle("Menu practice GUI");
        btnEx1 = findViewById(R.id.btnEx1);
        btnEx2 = findViewById(R.id.btnEx2);
        btnEx4 = findViewById(R.id.btnEx4);
        btnExit = findViewById(R.id.btnExit);

        btnEx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEx1 = new Intent(MainActivity.this, Ex1_EventProgramming.class);
                startActivity(iEx1);
            }
        });
        btnEx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEx2 = new Intent(MainActivity.this, Ex2_TemperatureConversion.class);
                startActivity(iEx2);
            }
        });

        btnEx4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEx4 = new Intent(MainActivity.this, Ex4_BMI.class);
                startActivity(iEx4);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }
}