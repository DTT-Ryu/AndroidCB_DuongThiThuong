package com.example.mycontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    ArrayList<MyContact> listContacts = new ArrayList<>();
    ContactAdapter contactAdapter;
    FloatingActionButton btnAdd;

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

        setTitle("List Contact");
        initData();
        lvContact = findViewById(R.id.lvContact);

        //khoi tao contactAdapter
        contactAdapter = new ContactAdapter(MainActivity.this, R.layout.layout_item_contact, listContacts);
        lvContact.setAdapter(contactAdapter);

        //xu ly sk cho nut floatting Button
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //goi InsContact de them moi contact
                Intent iIns = new Intent(MainActivity.this, insContactActivity.class);
                insertContactResult.launch(iIns);
            }
        });

    }

    ActivityResultLauncher<Intent> insertContactResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            //xu ly kq tra ve o day
            if(o.getResultCode()==RESULT_OK){
                Intent intent = o.getData();
                MyContact contact = (MyContact) intent.getExtras().getSerializable("contact");
                //add vao list contact
                listContacts.add(contact);
                //refresh adapter
                contactAdapter.notifyDataSetChanged();
            }
        }
    });


    private void initData() {

        listContacts.add(new MyContact(R.drawable.img2, "Mai", "0987654321"));
        listContacts.add(new MyContact(R.drawable.img2, "Linh", "01111111111"));
        listContacts.add(new MyContact(R.drawable.img2, "Tuan", "0222222222"));
        listContacts.add(new MyContact(R.drawable.img2, "Van Anh", "033333333"));
        listContacts.add(new MyContact(R.drawable.img2, "Mai", "0444444444"));

    }
}