package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LinearLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
    }

    /*층을 만들어서 관리하는 레이아웃
    * gravity : 정렬
    * orientation : 가로로, 세로로 컴포넌트를 정렬시킨다. 초기값은 가로(horizontal)
    * layout_weight : 각 컴포넌트의 위치를 지정할때 분배해주는 영역크기 1:1:1 하면 전부 33%씩 영역을 갖는다.
    * */
}