package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class FragmentBundleEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_bundle_ex);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentBd1 fragmentBd1 = new FragmentBd1();
        transaction.replace(R.id.frameLayout, fragmentBd1);
        transaction.commit();
    }
}