package com.example.randomnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean isBound = false;
    private BoundExample service;
    private TextView textView;
    private DisplayRandomAsyncTask displayRandomAsyncTask;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BoundExample.LocalBinder binder= (BoundExample.LocalBinder) iBinder;
            service= binder.getService();
            isBound=true;
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound=false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        displayRandomAsyncTask = new DisplayRandomAsyncTask();
        displayRandomAsyncTask.execute();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Intent intent = new Intent (this,BoundExample.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isBound && service != null) {
            unbindService(serviceConnection);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != displayRandomAsyncTask){
            if (!displayRandomAsyncTask.isCancelled()) {
                displayRandomAsyncTask.cancel(true);
            }
        }
    }

    private class DisplayRandomAsyncTask extends AsyncTask<Void, Integer, Void> {
     @Override
     protected Void doInBackground(Void... voids){
         for(int i=0; i<=10; i++) {
             if(isBound && service != null){
                 publishProgress(service.getRandom());
             }
             SystemClock.sleep(1000);
         }
             return null;
     }
        @Override
        protected void onProgressUpdate (Integer... values) {
         super.onProgressUpdate(values);
         textView.setText(String.valueOf(values[0]));
        }
    }
}