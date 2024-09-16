package com.example.lab2;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.*;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class Ex1Activity extends AppCompatActivity {
    int imgID[]={R.drawable.cat, R.drawable.bear, R.drawable.dog, R.drawable.turtle, R.drawable.penguin};
    int colorID[]={R.color.bkg1, R.color.bkg2, R.color.bkg3, R.color.bkg4, R.color.bkg5};

    LinearLayout layoutMain;
    ImageView imgView;
    ProgressBar prgBar;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ex1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getView();
        prgBar = findViewById(R.id.progressBar);
        customProgressBar();
    }
    private void getView(){
        layoutMain = findViewById(R.id.layoutMain);
        imgView = findViewById(R.id.imgAnimal);
        layoutMain.setBackgroundColor(getResources().getColor(colorID[new Random().nextInt(colorID.length)], null));
        imgView.setImageResource(imgID[new Random().nextInt(imgID.length)]);
    }
    int count = 0;
    private void customProgressBar(){
        prgBar.setProgress(0);
        prgBar.setMax(100);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    prgBar.setProgress(count);
                    while (prgBar.getProgress() <= prgBar.getMax()){
                        count++;
                        try{
                            Thread.sleep(30);
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    prgBar.setProgress(count);
                                }
                            });
                            if(prgBar.getProgress() == prgBar.getMax()){
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        prgBar.setProgress(0);
                                    }
                                });
                                count =0;
                                break;
                            }
                        }catch (InterruptedException e){
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();
    }

}










