package com.example.warrrapp.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.example.warrrapp_ACTION")){
            Toast.makeText(context, "War Started.. " ,Toast.LENGTH_SHORT).show();
        }
    }
}
