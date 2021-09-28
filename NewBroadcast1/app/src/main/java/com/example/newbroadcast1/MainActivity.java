package com.example.newbroadcast1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MyReceiver myReceiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        protected void onStart(){
            super.onStart();

            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
            intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
            intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
            this.registerReceiver(myReceiver, intentFilter);
        }
        protected void onStop() {
        super.onStop();
        this.unregisterReceiver(myReceiver);
        }
    }
