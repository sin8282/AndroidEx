package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

/*Manifest설정이 필요함. permission INTERNET, activity android
    <uses-permission android:name="android.permission.INTERNET" />
    android:screenOrientation="landscape"
    android:theme="@style/Theme.AppCompat.Light.NoActionBar"
*/

public class VideoViewExActivity extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;
    private String videoUrl  = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view_ex);

        videoView = findViewById(R.id.videoView);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse(videoUrl);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.start();

    }
}