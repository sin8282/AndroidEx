package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicPlayerActivity2 extends AppCompatActivity {

    Button play_btn;
    Button stop_btn;

    MediaPlayer mediaPlayer;


    //앱이 종료될때도 미디어 플레이어가 초기화 되게 함
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player2);


        play_btn = findViewById(R.id.play_btn);
        stop_btn = findViewById(R.id.stop_btn);

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer == null ){
                    mediaPlayer = MediaPlayer.create(MusicPlayerActivity2.this,R.raw.abc);
                    mediaPlayer.start();
                }
                else if(!mediaPlayer.isPlaying()){
                    mediaPlayer = MediaPlayer.create(MusicPlayerActivity2.this,R.raw.abc);
                    mediaPlayer.start();
                }
            }
        });

        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            }
        });



    }
}