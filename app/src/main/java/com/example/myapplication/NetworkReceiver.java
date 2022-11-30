package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.widget.TextView;

public class NetworkReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(intent.getAction())){
            NetworkInfo info = (NetworkInfo) intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            NetworkInfo.DetailedState state = info.getDetailedState();
            if(state == NetworkInfo.DetailedState.CONNECTED){
                BroadCastReceiver.tv_state.setText("네트워크가 연결되었습니다.");
            }else if (state == NetworkInfo.DetailedState.DISCONNECTED){
                BroadCastReceiver.tv_state.setText("네트워크가 연결실패했습니다.");
            }
        }
    }
}
