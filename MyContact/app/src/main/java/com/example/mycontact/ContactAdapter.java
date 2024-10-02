package com.example.mycontact;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<MyContact> {
    Context context;
    int layout;
    ArrayList<MyContact> myListContact;

    public ContactAdapter(@NonNull Context context, int resource, ArrayList<MyContact> lstContact) {
        super(context, resource, lstContact);
        this.context = context;
        this.layout = resource;
        this.myListContact = lstContact;
    }
    //viet lai cac phuong thuc cua arrayadapter: getView,, getItem...
    @Nullable
    @Override
    public MyContact getItem(int position) {
        return myListContact.get(position);
    }

    @Override
    public int getCount() {
        return myListContact.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView= convertView;
        if(currentView== null){
            //load layout item len de hien thi du lieu
            currentView= LayoutInflater.from(context).inflate(layout,parent, false);
        }
        //lay ra doi tuong myContact tai vi tri position, su dung myContact nay de fill du lieu vao hien thi
        MyContact contact = getItem(position);
        ImageView imgContact = currentView.findViewById(R.id.imgContact);
        TextView tvName = currentView.findViewById(R.id.tvName);
        TextView tvPhone = currentView.findViewById(R.id.tvPhoneNumber);
        ImageButton btnCall = currentView.findViewById(R.id.btnCall);
        ImageButton btnSend = currentView.findViewById(R.id.btnSend);

        //set thong tin cho textview - data bind
        tvName.setText(contact.getName());
        tvPhone.setText(contact.getPhone());

        //xu ly su kien cho cac nut lenh btnCall va btnSend
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make a phone call
                Intent iCall = new Intent(Intent.ACTION_DIAL);
                iCall.setData(Uri.parse("tel:"+contact.getPhone()));
                context.startActivity(iCall);

            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send a message
                Uri smsUri = Uri.parse("smsto:"+contact.getPhone());
                Intent iSMS = new Intent(Intent.ACTION_SENDTO, smsUri);
                iSMS.putExtra("sms_body", "input sms message");
                context.startActivity(iSMS);

            }
        });

        //data bind imageView
        assert  contact != null;
        imgContact.setImageResource(contact.getImageID());

        return currentView;
    }




}
