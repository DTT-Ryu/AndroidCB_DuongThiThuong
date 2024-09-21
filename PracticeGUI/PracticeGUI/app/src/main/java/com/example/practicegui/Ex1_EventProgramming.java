package com.example.practicegui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;


import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ex1_EventProgramming extends AppCompatActivity {
    TextView txtKQ;
    EditText edtSoA, edtSoB;
    Button btnTong, btnHieu, btnTich, btnThuong, btnUCLN, btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex1_event_programming);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setTitle("Lập trình sự kiện");
        calculateNumber();

    }
    private void calculateNumber(){
        txtKQ = findViewById(R.id.tvKQ);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        btnTich = findViewById(R.id.btnTich);
        btnThuong = findViewById(R.id.btnThuong);
        btnUCLN = findViewById(R.id.btnUCLN);
        btnThoat = findViewById(R.id.btnThoat);
        edtSoA = findViewById(R.id.edtSoA);
        edtSoB = findViewById(R.id.edtSoB);

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a, b;
                try{
                    a = Integer.parseInt(edtSoA.getText().toString());
                    b = Integer.parseInt(edtSoB.getText().toString());
                }catch (NumberFormatException e){
                    Toast.makeText(Ex1_EventProgramming.this, "Nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
                    return;
                }
                int kq = a + b;
                txtKQ.setText(String.valueOf(kq));
            }
        });

        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a, b;
                try{
                    a = Integer.parseInt(edtSoA.getText().toString());
                    b = Integer.parseInt(edtSoB.getText().toString());
                }catch (NumberFormatException e){
                    Toast.makeText(Ex1_EventProgramming.this, "Nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
                    return;
                }
                int kq = a - b;
                txtKQ.setText(String.valueOf(kq));
            }
        });

        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a, b;
                try {
                    a = Integer.parseInt(edtSoA.getText().toString());
                    b = Integer.parseInt(edtSoB.getText().toString());
                }catch (NumberFormatException e){
                    Toast.makeText(Ex1_EventProgramming.this, "Nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
                    return;
                }
                int kq = a * b;
                txtKQ.setText(String.valueOf(kq));
            }
        });

        btnThuong.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a, b;
                try {
                    a = Integer.parseInt(edtSoA.getText().toString());
                    b = Integer.parseInt(edtSoB.getText().toString());
                }catch (NumberFormatException e){
                    Toast.makeText(Ex1_EventProgramming.this, "Nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(b == 0){
                    Toast.makeText(Ex1_EventProgramming.this, "Số B phải khác 0", Toast.LENGTH_SHORT).show();
                }else{
                    int kq = a/b;
                    txtKQ.setText(String.valueOf(kq));
                }
            }
        }));

        btnUCLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a, b;
                try{
                    a = Integer.parseInt(edtSoA.getText().toString());
                    b = Integer.parseInt(edtSoB.getText().toString());
                }catch (NumberFormatException e){
                    Toast.makeText(Ex1_EventProgramming.this, "Nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
                    return;
                }
                int kq = timUCLN(a, b);
                txtKQ.setText(String.valueOf(kq));
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack1 = new Intent(Ex1_EventProgramming.this, MainActivity.class);
                startActivity(iBack1);
//                finish();

            }
        });
    }
    public static int timUCLN(int a, int b){
        while (b != 0){
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}