package com.example.firstprogram;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.*;
//import android.widget.*;

public class MainActivity extends AppCompatActivity {
    EditText txtX, txtY;
    TextView txtResult;
    Button btnPlus, btnSubtract, btnMulti, btnDivi, btnDivi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        innitControl();
    }
    private void innitControl(){
        txtX=findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtResult = findViewById(R.id.txtResult);
        btnPlus = findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int x = Integer.parseInt(txtX.getText().toString());
                int y = Integer.parseInt(txtY.getText().toString());
                int result = x + y;
                txtResult.setText(String.valueOf(result));
            }
        });

        btnSubtract = findViewById(R.id.btnSubtract);
        btnSubtract.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(txtX.getText().toString());
                int y = Integer.parseInt(txtY.getText().toString());
                int result = x - y;
                txtResult.setText(String.valueOf(result));
            }
        }));

        btnMulti = findViewById(R.id.btnMulti);
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(txtX.getText().toString());
                int y = Integer.parseInt(txtY.getText().toString());
                int result = x*y;
                txtResult.setText(String.valueOf(result));
            }
        });

        btnDivi = findViewById(R.id.btnDivi);
        btnDivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt((txtX.getText().toString()));
                int y = Integer.parseInt((txtY.getText().toString()));
                int result = x/y;
                txtResult.setText(String.valueOf(result));
            }
        });

        btnDivi2 = findViewById(R.id.btnDivi2);
        btnDivi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt((txtX.getText().toString()));
                int y = Integer.parseInt((txtY.getText().toString()));
                int result = x%y;
                txtResult.setText(String.valueOf(result));
            }
        });


    }
}