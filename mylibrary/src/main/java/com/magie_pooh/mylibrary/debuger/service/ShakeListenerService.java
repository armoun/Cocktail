package com.magie_pooh.mylibrary.debuger.service;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.IBinder;

import com.magie_pooh.mylibrary.debuger.model.ShakeCallback;
import com.magie_pooh.mylibrary.debuger.receiver.DebuggerControlReceiver;
import com.magie_pooh.mylibrary.debuger.ui.activity.RecipeActivity;

/**
 * Created by magie-pooh on 2015/03
 */
public class ShakeListenerService extends Service implements ShakeCallback.Callback {

    @SuppressWarnings("unused")
    private static final String TAG = ShakeListenerService.class.getSimpleName();
    private DebuggerControlReceiver mReceiver = new DebuggerControlReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            stopSelf();
        }
    };
    private SensorManager mSensorManager;
    private ShakeCallback mShakeCallback;

    public static Intent getIntent(final Context context) {
        return new Intent(context, ShakeListenerService.class);
    }

    public static void startService(final Activity activity) {
        final Intent intent = new Intent(activity, ShakeListenerService.class);
        activity.startService(intent);
    }

    public static void startService(final Context context) {
        context.startService(new Intent(context, ShakeListenerService.class));
    }

    public static void stopService(final Activity activity) {
        activity.stopService(new Intent(activity, ShakeListenerService.class));
    }

    public static void stopService(final Context context) {
        final Intent intent = new Intent(context, ShakeListenerService.class);
        context.startService(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mShakeCallback = new ShakeCallback(this);
        registerReceiver(mReceiver, DebuggerControlReceiver.getIntentFilter());
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mSensorManager.registerListener(
                mShakeCallback, mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_NORMAL);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSensorManager.unregisterListener(mShakeCallback);
        unregisterReceiver(mReceiver);
    }

    @Override
    public void onShake() {
        RecipeActivity.startActivity(this);
    }
}
