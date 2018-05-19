package com.example.anujdawar.backgroundservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread serviceStartThread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Intent intent1 = new Intent(MainActivity.this, MyService.class);
                    startService(intent1);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "exception caught here", Toast.LENGTH_SHORT).show();
                }
            }
        });

        serviceStartThread.start();
    }
}