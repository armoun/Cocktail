package com.magie_pooh.mylibrary.debuger.ui.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import com.magie_pooh.mylibrary.R;
import com.magie_pooh.mylibrary.debuger.receiver.DebuggerControlReceiver;
import com.magie_pooh.mylibrary.debuger.service.ShakeListenerService;

/**
 * Created by magie-pooh on 2015/03
 */
public class ControllerNotification {

    @SuppressWarnings("unused")
    private static final String TAG = ControllerNotification.class.getSimpleName();

    private static final int NOTI_ID = 1234;
    private static final int REQUEST_START = 1000;
    private static final int REQUEST_STOP = 1001;

    public static void show(final Context context) {
        final RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                R.layout.notification_controll);
        remoteViews.setOnClickPendingIntent(R.id.play, createStartPendingIntent(context));
        remoteViews.setOnClickPendingIntent(R.id.pause, createStopPendingIntent(context));

        final Notification notification = new NotificationCompat.Builder(context)
                .setContent(remoteViews)
                .setSmallIcon(R.drawable.ic_cocktail)
                .build();
        ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE))
                .notify(NOTI_ID, notification);
    }

    private static PendingIntent createStartPendingIntent(final Context context) {
        return PendingIntent.getService(context, REQUEST_START,
                ShakeListenerService.getIntent(context), PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private static PendingIntent createStopPendingIntent(final Context context) {
        return PendingIntent.getBroadcast(context, REQUEST_STOP,
                DebuggerControlReceiver.getBroadcastIntent(), 0);
    }
}
