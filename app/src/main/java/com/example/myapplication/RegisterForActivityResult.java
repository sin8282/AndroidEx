package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterForActivityResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_for_result);

        findViewById(R.id.btn_move).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterForActivityResult.this, RFARSubActivity.class);
                getRFARSubResult.launch(intent);
                //startActivity, startActivityForResult 랑 같은 기능이다.

            }
        });
    }

    private final ActivityResultLauncher<Intent> getRFARSubResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                // 서브화면에서 넘어오는 결과값을 확인
                if(result.getResultCode() == RESULT_OK){
                    TextView tv_result = findViewById(R.id.tv_result);
                    tv_result.setText(result.getData().getStringExtra("value"));
                }
            }
    );

}