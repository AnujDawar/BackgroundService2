package com.example.anujdawar.backgroundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyService extends Service
{
    Handler myHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            Toast.makeText(getApplicationContext(), "Service Started here", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, final int flags, int startId)
    {
        Thread indefiniteThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(true)
                {
                    myHandler.sendEmptyMessage(0);

                    try
                    {
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        indefiniteThread.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy()
    {
        Toast.makeText(MyService.this, "Service Stopped", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}