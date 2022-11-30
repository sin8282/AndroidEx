package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentBd1 extends Fragment {

    private View view;
    private TextView tv_fragment1;
    private Button btn_fragmentbd1;
    private String result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentbd_1,container, false);

        tv_fragment1 = view.findViewById(R.id.tv_fragment1);
        btn_fragmentbd1 = view.findViewById(R.id.btn_fragmentbd1);

        if (getArguments() != null){
            result = getArguments().getString("fromFrag2");
            tv_fragment1.setText(result);
        }

        btn_fragmentbd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("fromFrag1","레이아웃 페이지는 그대로이지만 이 문장을 넘김");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentBd2 fragmentBd2 = new FragmentBd2();
                fragmentBd2.setArguments(bundle);
                transaction.replace(R.id.frameLayout, fragmentBd2);
                transaction.commit();

            }
        });

        return view;
    }

}
