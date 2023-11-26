package com.example.arminbakhshi_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Receiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onResume() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            receiver = new Receiver();
            registerReceiver(receiver,
                    new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        super.onResume();
    }
    @Override
    protected void onPause() {
         unregisterReceiver(receiver);
         super.onPause();

    }


}