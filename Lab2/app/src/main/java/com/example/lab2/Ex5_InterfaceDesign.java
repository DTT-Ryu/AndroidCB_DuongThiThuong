package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ex5_InterfaceDesign extends AppCompatActivity {
    Button btnBackEx5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex5_interface_design);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnBackEx5 = findViewById(R.id.btnBackEx5);
        btnBackEx5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMain3 = new Intent(Ex5_InterfaceDesign.this, MainActivity.class);
                startActivity(iMain3);
            }
        });
    }
}