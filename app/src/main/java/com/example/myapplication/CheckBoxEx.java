package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckBoxEx extends AppCompatActivity {

    private CheckBox chk_red, chk_blue, chk_green;
    private TextView tv_result;
    private Button btn_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_ex);

        chk_red = findViewById(R.id.chk_red);
        chk_blue = findViewById(R.id.chk_blue);
        chk_green = findViewById(R.id.chk_green);
        tv_result = findViewById(R.id.tv_result);
        btn_result = findViewById(R.id.btn_result);

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String init = "";
                if(chk_red.isChecked()){
                    init += chk_red.getText().toString();
                }if (chk_blue.isChecked()){ // 체크박스이므로 else if를 안쓴다.
                    init += chk_blue.getText().toString();
                }if (chk_green.isChecked()){ // 체크박스이므로 else if를 안쓴다.
                    init += chk_green.getText().toString();
                }

                tv_result.setText(init);
            }
        });
    }
}