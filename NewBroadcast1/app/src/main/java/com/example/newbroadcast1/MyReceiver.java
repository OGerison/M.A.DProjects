package com.example.newbroadcast1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isOn = intent.getBooleanExtra("state", false);
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            if (isOn=true){
                Toast.makeText(context, "Airplane Mode On", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(context, "Airplane Mode Off", Toast.LENGTH_SHORT).show();
        }
        if (Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())) {
            Toast.makeText(context, "Power Connected", Toast.LENGTH_SHORT).show();
        }
        if(Intent.ACTION_POWER_DISCONNECTED.equals(intent.getAction())) {
            Toast.makeText(context, "Power Disconnected", Toast.LENGTH_SHORT).show();
        }
    }
}