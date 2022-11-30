package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

public class BroadCastReceiver extends AppCompatActivity {

    public static TextView tv_state;
    private NetworkReceiver networkReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_receiver);

        tv_state = findViewById(R.id.tv_state);


        IntentFilter filter = new IntentFilter(); // intent는 너한테 보낼게, intentFilter는 나한테 보내줘.
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION); // filter 기능은 NETWORK STATE CHANGED ACTION을 확인해봐라

        networkReceiver = new NetworkReceiver();
        registerReceiver(networkReceiver,filter);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //연결상태를 더 이상 필요 없다 판단되면, 파괴
        unregisterReceiver(networkReceiver);
    }
}