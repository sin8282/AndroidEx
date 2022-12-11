package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityLifeCycleExBinding;
import com.example.myapplication.databinding.ActivityViewBindingExBinding;

// 생명주기 순서 해당 연습페이지는 로그를 확인해가며 공부하기.
// onCreate() >> onStart() >> onResume() >> 'Activity Running' >> 'if 바깥으로 나가면,' >> onPause() >> onStop() >> { onDestroy() 'OR' onRestart() }
public class LifeCycleEx extends AppCompatActivity {

    ActivityLifeCycleExBinding activityLifeCycleExBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_life_cycle_ex);

        //뷰바인딩하기
        LayoutInflater inflater = getLayoutInflater();
        activityLifeCycleExBinding = ActivityLifeCycleExBinding.inflate(inflater);
        View view = activityLifeCycleExBinding.getRoot();
        setContentView(view);

        activityLifeCycleExBinding.btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LifeCycleEx.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(LifeCycleEx.this, " onStop() >> onDestroy()", Toast.LENGTH_SHORT).show();
            }
        });
        activityLifeCycleExBinding.btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LifeCycleEx.this, LifeCycleSubEx.class);
                startActivity(intent);
            }
        });


        Log.e("생명주기 테스트하기 ::", "onCreate");
        //activity 또는 fragment가 실행이 되었을때...
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("생명주기 테스트하기 ::", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("생명주기 테스트하기 ::", "onResume");
        // 중지 되어있던 activity가 다시 재개 되었을때...
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("생명주기 테스트하기 ::", "onPause");
        // Pause상태일때 진행되는... (홈버튼을 눌러서 바깥으로 잠깐 빠져 나갔을 때, 다른 Activity가 활성화 되었을때...)
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("생명주기 테스트하기 ::", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("생명주기 테스트하기 ::", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("생명주기 테스트하기 ::", "onDestroy");
        // 화면이 Destroy되었을때...
    }


}