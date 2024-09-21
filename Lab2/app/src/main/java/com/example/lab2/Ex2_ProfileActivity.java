package com.example.lab2;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.Manifest;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ex2_ProfileActivity extends AppCompatActivity {
    ImageView imgCall;
    TextView txtPhoneNumber;
    Button btnBackEx2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex2_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imgCall = findViewById(R.id.imgCall);
        txtPhoneNumber = findViewById(R.id.txtPhoneNumber);
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel: "+ txtPhoneNumber.getText().toString().trim()));
                if(ActivityCompat.checkSelfPermission(Ex2_ProfileActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(Ex2_ProfileActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;
                }
                startActivity(iCall);
            }
        });
        btnBackEx2 = findViewById(R.id.btnBackEx2);
        btnBackEx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMain2 = new Intent(Ex2_ProfileActivity.this, MainActivity.class);
                startActivity(iMain2);
            }
        });
    }
}