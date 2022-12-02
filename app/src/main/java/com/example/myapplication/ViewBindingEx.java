package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.ActivityViewBindingExBinding;

public class ViewBindingEx extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding; // 이건 메인이고
    private ActivityViewBindingExBinding activityViewBindingExBinding; // 이건 이 레이아웃을 바라보는 뷰바인딩이 된다.
    // 이처럼 매서드선언이 Activity+layout파일이름+Binding이 되는거다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_binding_ex);
        // 액티비티 바인딩에 할당 뷰 설정
        LayoutInflater inflater = getLayoutInflater();
        activityViewBindingExBinding = ActivityViewBindingExBinding.inflate(inflater);
        View view = activityViewBindingExBinding.getRoot();
        setContentView(view);

        activityViewBindingExBinding.tvVB.setText("이렇게 findView를 안해도 바로 setText를 사용가능합니다.");
        // 보면 신기한게 layout에 tv_VB언더바로 id를 선언해도 사라진걸 확인 가능하다. 지좆대로 편한데로 바꾸는듯
        activityViewBindingExBinding.btnVB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewBindingEx.this, "findView안써도 존나 편하게 선언됨...", Toast.LENGTH_SHORT).show();
            }
        });

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.VBmain_frame , new ViewBindingFragment());
        ft.commit();

    }
}