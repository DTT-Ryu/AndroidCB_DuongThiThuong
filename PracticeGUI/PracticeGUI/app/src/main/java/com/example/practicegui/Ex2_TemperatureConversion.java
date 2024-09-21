package com.example.practicegui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ex2_TemperatureConversion extends AppCompatActivity {
    Button btnToC, btnToF, btnClear, btnBack;
    EditText txtF, txtC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex2_temperature_conversion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setTitle("Temperature Conversion");
        tempConversion();
    }
    private void tempConversion(){
        txtF = findViewById(R.id.txtF);
        txtC = findViewById(R.id.txtC);
        btnToC = findViewById(R.id.btnToC);
        btnToF = findViewById(R.id.btnToF);
        btnClear = findViewById(R.id.btnClear);
        btnBack = findViewById(R.id.btnBack2);
        btnToC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float f;
                try{
                    f = Float.parseFloat(txtF.getText().toString());
                }catch (NumberFormatException e){
                    Toast.makeText(Ex2_TemperatureConversion.this, "Please enter a number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                float c = (f - 32) * (5.0f/9.0f);
                txtC.setText(String.valueOf(c));
            }
        });

        btnToF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float c;
                try{
                    c = Float.parseFloat(txtC.getText().toString());
                }catch (NumberFormatException e){
                    Toast.makeText(Ex2_TemperatureConversion.this, "Please enter a number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                float f = c * (9.0f/5.0f) + 32;
                txtF.setText(String.valueOf(f));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtF.setText("");
                txtC.setText("");
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack2 = new Intent(Ex2_TemperatureConversion.this, MainActivity.class);
                startActivity(iBack2);
            }
        });
    }
}