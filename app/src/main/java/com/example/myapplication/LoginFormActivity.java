package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginFormActivity extends AppCompatActivity {

    private TextView tv_id, tv_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        Intent intent = getIntent();
        tv_id = findViewById(R.id.tv_id);
        tv_pass = findViewById(R.id.tv_pass);

        String userId = intent.getStringExtra("userId");
        String userPassword = intent.getStringExtra("userPassword");

        tv_id.setText(userId);
        tv_pass.setText(userPassword);
    }
}