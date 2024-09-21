package com.example.lab2;

import android.Manifest;
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
    Button btnEx1, btnEx2, btnEx5, btnExit;
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
        btnEx1 = findViewById(R.id.btnEx1);
        btnEx2 = findViewById(R.id.btnEx2);
        btnEx5 = findViewById(R.id.btnEx5);
        btnExit = findViewById(R.id.btnExit);
        btnEx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEx1 = new Intent(MainActivity.this, Ex1Activity.class);
                startActivity(iEx1);
            }
        });
        btnEx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEx2 = new Intent(MainActivity.this, Ex2_ProfileActivity.class);
                startActivity(iEx2);
            }
        });
        btnEx5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEx5 = new Intent(MainActivity.this, Ex5_InterfaceDesign.class);
                startActivity(iEx5);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}