package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentvbBinding;

public class ViewBindingFragment extends Fragment {

    private FragmentvbBinding fragmentvbBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentvbBinding = FragmentvbBinding.inflate(inflater,container,false);
        fragmentvbBinding.tvFragment.setText("짜잔입니다.");

        return fragmentvbBinding.getRoot(); // 프레그먼트도 뷰바인딩을 사용하면 context를 리턴하지않고 다음과같이 return한다.

    }
}
