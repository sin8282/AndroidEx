package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RelativeLayoutActivity extends AppCompatActivity {

    TextView explain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        String s = "관련있는 레이아웃을 연결하여서 관리하는 레이아웃"
                + "\nbelow 속성을 이용해서 해당 객체 하단에 오게금설정 가능하다."
                + "\ntoRightOf을 이용하여 오른쪽으로 오게 가능하다. to Of 속성은 왼쪽 오른쪽 위 아래 다양하게 있다. "
                + "\n그밖에도 align를 이용하여, center를 이용하여 배치가 가능하다."
                + "\n때문에 따로 gravity의 속성을 이용하지 않고 다양한 위치선정 레이아웃을 이용하여 배치한다.";
        explain = findViewById(R.id.explain);
        explain.setText(s);


    }
    /*관련있는 레이아웃을 연결하여서 관리하는 레이아웃
       * below 속성을 이용해서 해당 객체 하단에 오게금설정 가능하다.
       * toRightOf을 이용하여 오른쪽으로 오게 가능하다. to Of 속성은 왼쪽 오른쪽 위 아래 다양하게 있다.
       * 그밖에도 align를 이용하여, center를 이용하여 배치가 가능하다.
       * 때문에 따로 gravity의 속성을 이용하지 않고 다양한 위치선정 레이아웃을 이용하여 배치한다.
     * */
}