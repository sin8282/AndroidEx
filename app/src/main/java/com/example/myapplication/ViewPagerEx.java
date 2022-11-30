package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class ViewPagerEx extends AppCompatActivity {

    private ViewPagerAdapter viewpagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        ViewPager2 viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        viewpagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),getLifecycle());

        viewPager.setAdapter(viewpagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText("OBJECT " + (position + 1))
        ).attach();


/*        List<String> tabElement = Arrays.asList("안","녕","하","세","요");

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position){
                TextView tv = new TextView(ViewPagerEx.this);
                tv.setText(tabElement.get(position));
                tab.setCustomView(tv);
            }
        }).attach();*/


    }

}