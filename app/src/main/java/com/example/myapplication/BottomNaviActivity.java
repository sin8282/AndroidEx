package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNaviActivity extends AppCompatActivity {


    private BottomNavigationView bottomNaviActivity;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navi);


        bottomNaviActivity = findViewById(R.id.bottomNavigation);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        setFrag(0);


        bottomNaviActivity.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_airplane:
                        setFrag(0);
                        break;
                    case R.id.action_bus:
                        setFrag(1);
                        break;
                    case R.id.action_workload:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });
    }

    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.bottomNaviMainFrame,fragment1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.bottomNaviMainFrame,fragment2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.bottomNaviMainFrame,fragment3);
                ft.commit();
                break;

        }


    }
}