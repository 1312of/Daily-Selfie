package com.coursera.dailyselfie;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    public static final String ACTION_ALARM_RECEIVER = "com.coursera.dailyselfie.AlarmReceiver";
    
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent resultIntent = new Intent(context, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_stat_image_camera_alt)
                .setContentTitle(context.getText(R.string.notification_title))
                .setContentText(context.getText(R.string.notification_sub_title))
                .setTicker(context.getText(R.string.notification_title))
                .setContentIntent(resultPendingIntent)
                .setAutoCancel(true);

        NotificationManager notifyMgr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notifyMgr.notify(0, builder.build());
    }

}
