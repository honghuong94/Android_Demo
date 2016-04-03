package com.example.leo94star.applove;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    TextView Loinhan;
    ListView Baihat;
    RelativeLayout manhinh;
    MediaPlayer song;
     ArrayList<String> mangtenBH,mangLoiNhan;
    ArrayList<Integer> mangMp3;
    public void Anhxa()
    {
        Loinhan = (TextView) findViewById(R.id.textView);
        Baihat = (ListView) findViewById(R.id.listView);
        manhinh = (RelativeLayout) findViewById(R.id.Manhinh2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Toast toast=Toast.makeText(Main2Activity.this,"Hãy xem nào  tình yêu của anh đấy ",   Toast.LENGTH_SHORT);
        toast.show();

        manhinh.setBackgroundResource(R.drawable.hinh1);

        song = MediaPlayer.create(getApplicationContext(),R.raw.bai2);
        song.start();

        Loinhan.setText("Hãy là người con gái mà anh yêu nhất ");
        HU();

        TaoMang();
        // Gán list mảng bài hát vào list View để chạy
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.activity_list_item,mangtenBH);
        Baihat.setAdapter(adapter);

        // sự kiện play  nhạc khi click vào 1 item bất kỳ

        Baihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                song.stop();// tát nhạc cữ
                song = MediaPlayer.create(getApplicationContext(),mangMp3.get(position)); // lấy nhạc mới và play
                song.start();
                // Hiển thị lời nhắn và tạo hiệu ứng lên Lời nhắn đã chọn
                Loinhan.setText(mangLoiNhan.get(position));
                HU();
            }
        });

    }
    // Tạo hiệu ứng zoom lời nhắn
    public void HU()
    {
        Animation zoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        zoom.reset();
        Loinhan.clearAnimation();
        Loinhan.startAnimation(zoom);
    }
    // Tạo mảng hiển thị lời nhắn và bài hát
    public void TaoMang()
    {
        mangtenBH= new ArrayList<String>();
        mangLoiNhan = new ArrayList<String>();
        mangMp3 = new ArrayList<Integer>();

        // gan noi dung
        mangMp3.add(R.raw.cryonmy);
        mangtenBH.add("Cry On My Shoulder - Super Star");
        mangLoiNhan.add("Đã có lúc anh là bờ vai của em chỉ để em khóc ....");

        mangMp3.add(R.raw.mylove);
        mangtenBH.add("My Love <3 - WestLife");
        mangLoiNhan.add("Tình yêu của anh dành cho em là tất cả");

        mangMp3.add(R.raw.yeu);
        mangtenBH.add("Y.Ê.U - Min St.319 ");
        mangtenBH.add("Y.Ê.U ");
        mangLoiNhan.add("Hãy yêu anh thật lòng em nhé... Mãi yêu em..");

    }


}
