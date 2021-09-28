package com.example.otimcustombroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.example.EXAMPLE_ACTION")) {
            //String receivedText = intent.getStringExtra("com.example.EXTRA_TEXT");
            Toast.makeText(context, "Broadcast Received.", Toast.LENGTH_LONG).show();
        }
    }
}