package com.example.leo94star.applove;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RelativeLayout manhinh ;
    MediaPlayer song;
    ImageView hinhanh;
    public void Anhxa()
    {

        manhinh = (RelativeLayout) findViewById(R.id.Manhinh1);
        hinhanh = (ImageView) findViewById(R.id.imageView);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toast toast=Toast.makeText(MainActivity.this,"Em đẹp lắm,cô bé <3  ",   Toast.LENGTH_SHORT);
        toast.show();
        manhinh.setBackgroundResource(R.drawable.hinh2);

        song= MediaPlayer.create(getApplicationContext(),R.raw.bai1);
        song.start();

        Animation hieuung = AnimationUtils.loadAnimation(this, R.anim.fade);
        hieuung.reset(); // khoi chay lai tu dau
        hinhanh.clearAnimation();
        hinhanh.startAnimation(hieuung); // hinh anh chay hieu ung cua Animation

        hinhanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                Intent activitymusic = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(activitymusic);
            }
        });
    }
}
