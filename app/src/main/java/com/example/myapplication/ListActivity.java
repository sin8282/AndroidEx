package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        List<String> data = new ArrayList<>();
        listItem = (ListView)findViewById(R.id.listItem);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        listItem.setAdapter(adapter);

        data.add("1번 배열");
        data.add("2번 배열");
        data.add("3번 배열");
        data.add("4번 배열");

        adapter.notifyDataSetChanged();
    }
}