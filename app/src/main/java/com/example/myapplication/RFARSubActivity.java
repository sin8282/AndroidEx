package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RFARSubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rfarsub);

       EditText et_input = findViewById(R.id.et_input);

       findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                String strInputValue = et_input.getText().toString();

               Intent intent = new Intent();
               intent.putExtra("value", strInputValue);
               setResult(RESULT_OK, intent);
               finish();
           }
       });
    }
}