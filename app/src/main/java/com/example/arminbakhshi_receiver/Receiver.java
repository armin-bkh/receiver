package com.example.arminbakhshi_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.widget.Toast;
public class Receiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context,Intent intent){
        if (network(context)) {
        Toast.makeText(context, "Successful connection", Toast.LENGTH_SHORT).show();
    } else {
        Toast.makeText(context, "not Successful connection", Toast.LENGTH_SHORT).show();
    }
}

    private boolean network(Context context) {
        try {
            ConnectivityManager manager =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo Info = manager.getActiveNetworkInfo();
            return (Info != null && Info.isConnected());
        }catch (NullPointerException e) {
            e.printStackTrace();
            return false;

        }
    }
}
