package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class SharedActivity extends AppCompatActivity {

    private EditText saveStr;
    String shared = "sharedBox"; //저장할 sharedKey

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        saveStr = (EditText) findViewById(R.id.saveStr);
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("save1",""); // 여긴 sharedBox라는 객체에 들어있는 key,value찾기
        saveStr.setText(value);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = saveStr.getText().toString();
        editor.putString("save1",value);
        editor.commit();
    }
}