package com.nicthulhu.timerthulhu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("AlarmReceiver", "onReceive() called");
        //Intent launchActivityIntent = new Intent(context, TimerManagerActivity.class);
        //launchActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //context.startActivity(launchActivityIntent);
        Toast.makeText(context, "AlarmRecever fired", Toast.LENGTH_SHORT).show();
    }
}
