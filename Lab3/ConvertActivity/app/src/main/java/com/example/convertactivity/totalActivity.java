package com.example.convertactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class totalActivity extends AppCompatActivity {
    EditText edtA, edtB;
    Button btnTinhTong, btnTroVe, btnThoat;
    TextView txtKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_total);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setTitle("Man hinh tinh tong");
        getViews();
        Intent i = getIntent();
        int valueA = i.getIntExtra("AA", 0);
        int valueB = i.getIntExtra("BB", 0);
        edtA.setText(String.valueOf(valueA));
        edtB.setText(String.valueOf(valueB));


        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a, b;
                try {
                    a = Integer.parseInt(edtA.getText().toString());
                    b = Integer.parseInt(edtB.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(totalActivity.this, "Nhap so!", Toast.LENGTH_SHORT).show();
                    return;
                }
                int kq = a + b;
                txtKQ.setText(String.valueOf(kq));
            }
        });

        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void getViews() {
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnTinhTong = findViewById(R.id.btnTinhTong);
        btnThoat = findViewById(R.id.btnThoat);
        btnTroVe = findViewById(R.id.btnTroVe);
        txtKQ = findViewById(R.id.txtKQ);
    }

}