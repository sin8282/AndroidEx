package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

public class LifeCycleSubEx extends Activity { // Activity로 바꾸고 Manifest에서도 테마를 투명으로 지정한다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_sub_ex);
    }
}