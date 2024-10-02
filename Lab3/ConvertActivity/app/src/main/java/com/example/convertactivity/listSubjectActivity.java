package com.example.convertactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class listSubjectActivity extends AppCompatActivity {
    ListView lvSubject;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_subject);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setTitle("Danh sach mon hoc");
        lvSubject = findViewById(R.id.lvSubject);
        btnBack=findViewById(R.id.btnBack);

        final String[] lstSubject = new String[]{"Cong nghe phan mem", "Web", "Android", "Giao dien",
                "Mang may tinh", "He dieu hanh"};
        ArrayAdapter adap = new ArrayAdapter(
                listSubjectActivity.this,
                android.R.layout.simple_list_item_1,
                lstSubject
        );
        lvSubject.setAdapter(adap);

        lvSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String kq = "Position: " + position + ", value = " + lstSubject[position];
                Toast.makeText(listSubjectActivity.this, kq, Toast.LENGTH_LONG).show();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}