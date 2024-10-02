package com.example.crabgame;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnPlay;
    ImageView imgView1, imgView2, imgView3;
//    int imgID[] = {R.drawable.a0, R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5};

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
        setTitle("Crab Game");
        getViews();
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int r = random.nextInt(6);
                Resources res = getResources();
                String mDraw1 = "a" + r;
                int drawID1 = res.getIdentifier(mDraw1, "drawable", getPackageName());
                Drawable dr1 = res.getDrawable(drawID1, null);
                imgView1.setImageDrawable(dr1);

                r = random.nextInt(6);
                String mDraw2 = "a" + r;
                int drawID2 = res.getIdentifier(mDraw2, "drawable", getPackageName());
                Drawable dr2 = res.getDrawable(drawID2, null);
                imgView2.setImageDrawable(dr2);

                r = random.nextInt(6);
                String mDraw3 = "a" + r;
                int drawID3 = res.getIdentifier(mDraw3, "drawable", getPackageName());
                Drawable dr3 = res.getDrawable(drawID3, null);
                imgView3.setImageDrawable(dr3);


//        imgView1.setImageResource(imgID[new Random().nextInt(imgID.length)]);
//        imgView2.setImageResource(imgID[new Random().nextInt(imgID.length)]);
//        imgView3.setImageResource(imgID[new Random().nextInt(imgID.length)]);
            }
        });
    }

    private void getViews() {
        btnPlay = findViewById(R.id.btnPlay);
        imgView1 = findViewById(R.id.imgView1);
        imgView2 = findViewById(R.id.imgView2);
        imgView3 = findViewById(R.id.imgView3);
    }
}


