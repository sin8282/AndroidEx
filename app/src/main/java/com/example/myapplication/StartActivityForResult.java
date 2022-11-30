package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivityForResult extends AppCompatActivity {

    private TextView tv_sfr;
    private Button read_btn;
    private static final int REQUEST_CODE = 777;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for_result);

        tv_sfr = findViewById(R.id.tv_sfr);
        read_btn = findViewById(R.id.read_btn);

        read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SAFSubActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Toast.makeText(this, "수신 완료", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "수신 실패", Toast.LENGTH_SHORT).show();
        }

        if (requestCode == REQUEST_CODE){
            String result = data.getStringExtra("result");
            tv_sfr.setText(result);
        }
    }


}