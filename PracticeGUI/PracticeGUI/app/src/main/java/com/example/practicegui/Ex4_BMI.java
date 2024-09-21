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

import java.text.DecimalFormat;

public class Ex4_BMI extends AppCompatActivity {
    Button btnBMI, btnBack4;
    EditText txtName, txtHeight, txtWeight, txtBMI, txtDiagnose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex4_bmi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setTitle("TinhChiSoBMI");

        btnBMI = findViewById(R.id.btnBMI);
        btnBack4 = findViewById(R.id.btnBack4);

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calBMI();
            }
        });
        btnBack4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEx4 = new Intent(Ex4_BMI.this, MainActivity.class);
                startActivity(iEx4);
            }
        });
    }
    private void calBMI(){
        txtName = findViewById(R.id.txtName);
        txtHeight = findViewById(R.id.txtHeight);
        txtWeight = findViewById(R.id.txtWeight);
        txtBMI = findViewById(R.id.txtBMI);
        txtDiagnose = findViewById(R.id.txtDiagnose);

        double h, w;
        try{
            h = Double.parseDouble(txtHeight.getText().toString());
            w = Double.parseDouble(txtWeight.getText().toString());
            if(h <= 0 || w <= 0){
                Toast.makeText(Ex4_BMI.this, "Chiều cao và cân nặng phải lớn hơn 0!", Toast.LENGTH_SHORT).show();
                return;
            }

            double BMI = w/Math.pow(h, 2);
            String diag = "";
            if(BMI<18){
                diag = "Gầy";
            }else if(BMI <= 24.9){
                diag = "Bình thường";
            }else if(BMI <= 29.9){
                diag = "Béo phì độ 1";
            }else if(BMI <= 34.9){
                diag = "Béo phì độ 2";
            }else{
                diag = "Béo phì độ 3";
            }
            DecimalFormat dcf = new DecimalFormat("#.0");
            txtBMI.setText(dcf.format(BMI));
            txtDiagnose.setText(diag);

        }catch (NumberFormatException e){
            Toast.makeText(Ex4_BMI.this, "Nhập số cho chiều cao, cân nặng!", Toast.LENGTH_SHORT).show();
            return;
        }


    }
}