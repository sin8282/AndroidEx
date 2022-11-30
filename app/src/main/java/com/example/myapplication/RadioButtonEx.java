package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RadioButtonEx extends AppCompatActivity {

    private RadioGroup rg_gender;
    private RadioButton rb_man, rb_woman;
    private Button btn_result;
    private String str_result;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_ex);

        rg_gender = findViewById(R.id.rg_gender);
        rb_man = findViewById(R.id.rb_man);
        rb_woman = findViewById(R.id.rb_woman);
        btn_result = findViewById(R.id.btn_result);
        tv_result = findViewById(R.id.tv_result);


        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.rb_man){
                    Toast.makeText(RadioButtonEx.this, "남자를 클릭하였습니다.", Toast.LENGTH_SHORT).show();
                    str_result = rb_man.getText().toString();
                }else{
                    Toast.makeText(RadioButtonEx.this, "여자를 클릭하였습니다.", Toast.LENGTH_SHORT).show();
                    str_result = rb_woman.getText().toString();
                }
            }
        });

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(str_result != null){
                    tv_result.setText(str_result);
                }else{
                    tv_result.setText("선택해주세요.");
                }

            }
        });
    }
}