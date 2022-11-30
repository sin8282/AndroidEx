package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SAFSubActivity extends AppCompatActivity {

    private EditText back_et;
    private Button close_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safsub);

        back_et = findViewById(R.id.back_et);
        close_btn = findViewById(R.id.close_btn);

        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("result",back_et.getText().toString());
                setResult(RESULT_OK, intent); // 결과값, 인텐트값설정
                finish(); // 현재 액티비티종료 잘쓰임
            }
        });

    }
}