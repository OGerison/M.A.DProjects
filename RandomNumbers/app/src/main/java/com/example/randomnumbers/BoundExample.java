package com.example.randomnumbers;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.security.Provider;
import java.util.Random;

public class BoundExample extends Service {

    private IBinder binder = new LocalBinder();
    private Random random = new Random();

    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class LocalBinder extends Binder{
        BoundExample getService(){
            return BoundExample.this;
        }
    }
    public int getRandom(){
        return random.nextInt();
    }
}
