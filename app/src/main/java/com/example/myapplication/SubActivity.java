package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    private TextView IntentString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_sub);
        Intent intent = getIntent();

        IntentString = findViewById(R.id.IntentString);
        IntentString.setText(intent.getStringExtra("str"));

    }
}