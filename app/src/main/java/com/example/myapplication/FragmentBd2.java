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

public class FragmentBd2 extends Fragment {

    private View view;
    private TextView tv_fragment2;
    private Button btn_fragmentbd2;
    private String result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentbd_2,container, false);

        tv_fragment2 = view.findViewById(R.id.tv_fragment2);
        btn_fragmentbd2 = view.findViewById(R.id.btn_fragmentbd2);

        if (getArguments() != null){
            result = getArguments().getString("fromFrag1");
            tv_fragment2.setText(result);
        }

        btn_fragmentbd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("fromFrag2","이번엔 이 문장 넘김 2");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentBd1 fragmentBd1 = new FragmentBd1();
                fragmentBd1.setArguments(bundle);
                transaction.replace(R.id.frameLayout, fragmentBd1);
                transaction.commit();

            }
        });

        return view;
    }

}
