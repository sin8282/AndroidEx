package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ViewPagerFragment3 extends Fragment {
    private View view;

    //viewPager을 상태를 계속 지속해줘야해서 기존 Fragment하고는 다르게 해당문이 추가가 된다.
    public static ViewPagerFragment3 newInstance(){
        ViewPagerFragment3 viewPagerFragment3 = new ViewPagerFragment3();
        return viewPagerFragment3;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.view_pager_fragment3,container,false);

        return view;
    }
}
