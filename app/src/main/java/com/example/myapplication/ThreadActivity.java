package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThreadActivity extends AppCompatActivity {

    private Button start_btn, stop_btn;
    private Thread thread;
    private TextView thread_text;
    boolean isThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        start_btn = findViewById(R.id.start_btn);
        stop_btn = findViewById(R.id.stop_btn);
        thread_text = findViewById(R.id.thread_text);

        //쓰레드 시작
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 isThread = true;
                 thread = new Thread(){
                     @Override
                     public void run(){
                         while(isThread){
                             try {
                                 sleep(5000);
                             } catch (InterruptedException e) {
                                 e.printStackTrace();
                             }
                             handler.sendEmptyMessage(0);
                         }
                     }
                 };
                 thread.start();
            }
        });


        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isThread = false;
            }
        });

    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            Toast.makeText(ThreadActivity.this, "쓰래드에 의해서 계속 실행됨", Toast.LENGTH_SHORT).show();
        }
    };

}