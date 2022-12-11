package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.auth.data.model.User;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

public class KakaoLoginSucsses extends AppCompatActivity {

    private String strNick, strProfileImg, strEmail;
    private Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakao_login_sucsses);

        Intent intent = getIntent();
        strNick = intent.getStringExtra("name");
        strEmail = intent.getStringExtra("eMail");
        strProfileImg =  intent.getStringExtra("profileImg");

        TextView tv_nickName = findViewById(R.id.tv_nickName);
        TextView tv_eMail = findViewById(R.id.tv_eMail);
        ImageView iv_profile = findViewById(R.id.iv_profile);


        tv_nickName.setText(strNick);
        tv_eMail.setText(strEmail);
        Glide.with(this).load(strProfileImg).into(iv_profile);


        findViewById(R.id.btn_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
                    @Override
                    public void onCompleteLogout() {
                        finish(); // 액티비티 종료
                    }
                });
            }
        });
    }


}