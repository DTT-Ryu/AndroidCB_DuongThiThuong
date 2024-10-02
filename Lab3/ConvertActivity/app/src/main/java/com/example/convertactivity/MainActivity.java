package com.example.convertactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnTotal, btnListSubject;
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
        setTitle("Man hinh chinh");
        btnTotal=findViewById(R.id.btnTotal);
        btnListSubject=findViewById(R.id.btnListSubject);

        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iTotal = new Intent(MainActivity.this, totalActivity.class);
                iTotal.putExtra("AA", 54);
                iTotal.putExtra("BB", 32);
                startActivity(iTotal);
            }
        });

        btnListSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iListSubject = new Intent(MainActivity.this, listSubjectActivity.class);
                startActivity(iListSubject);
            }
        });
    }
}