package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.util.exception.KakaoException;

public class KakaoLoginEx extends AppCompatActivity {

    private ISessionCallback iSessionCallback;
    private TextView tv_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakao_login_ex);

        String keyHash = com.kakao.util.helper.Utility.getKeyHash(this /* context */);
        System.out.println("Kakao Hash key extract :: "+keyHash ); // 해시키 추출하기

        tv_status = findViewById(R.id.tv_status);

        iSessionCallback = new ISessionCallback() {
            @Override
            public void onSessionOpened() {

                //로그인 요청
                UserManagement.getInstance().me(new MeV2ResponseCallback() {
                    @Override
                    public void onFailure(ErrorResult errorResult) {
                        tv_status.setText("오류발생입니다.");
                        Toast.makeText(KakaoLoginEx.this, "오류발생입니다.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSessionClosed(ErrorResult errorResult) {
                        tv_status.setText("로그인 세션이 종료되었습니다.");
                        Toast.makeText(KakaoLoginEx.this, "로그인 세션이 종료되었습니다.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(MeV2Response result) {
                        Intent intent = new Intent(KakaoLoginEx.this, KakaoLoginSucsses.class);
                        intent.putExtra("name", result.getKakaoAccount().getProfile().getNickname());
                        intent.putExtra("profileImg", result.getKakaoAccount().getProfile().getProfileImageUrl());
                        intent.putExtra("eMail", result.getKakaoAccount().getEmail());
                        startActivity(intent);
                        tv_status.setText("로그인 세션 성공!");
                        Toast.makeText(KakaoLoginEx.this, "로그인 세션 성공!", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onSessionOpenFailed(KakaoException exception) {
                Log.e("ERROR" , exception.toString());
                tv_status.setText("세션생성 실패");
                Toast.makeText(KakaoLoginEx.this, "세션생성 실패", Toast.LENGTH_SHORT).show();
            }
        };

        Session.getCurrentSession().addCallback(iSessionCallback); // 세션을 저장한다.
        Session.getCurrentSession().checkAndImplicitOpen();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { // LoginSucsses로 넘어가서 그결과를 받아오는 과정이다 카카오 api에서 이렇게 사용하게 만들어놨다.
        if (Session.getCurrentSession().handleActivityResult(requestCode,resultCode,data)){
            super.onActivityResult(requestCode, resultCode, data);
            Log.i("Kakao Result :: ",data.toString());
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Session.getCurrentSession().removeCallback(iSessionCallback); //해당 Activity가 종료 되면, 세션을 종료한다
    }
}