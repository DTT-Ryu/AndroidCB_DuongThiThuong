package com.example.mycontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class insContactActivity extends AppCompatActivity {
    EditText etPhone, etName;
    Button btnSave, btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ins_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setTitle("Add New Contact");
        getViews();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tra ve doi tuong contact can them cho MainActivity
                Intent iResult = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("contact", getContact());
                iResult.putExtras(bundle);
                setResult(RESULT_OK, iResult);
                //dong activity
                finish();
            }
        });

    }


    private void getViews(){
        etName=findViewById(R.id.edtName);
        etPhone=findViewById(R.id.edtPhoneNumber);
        btnClose=findViewById(R.id.btnClose);
        btnSave=findViewById(R.id.btnSave);
    }

    private MyContact getContact(){
        return new MyContact(R.drawable.img2, etName.getText().toString(), etPhone.getText().toString());

    }


}