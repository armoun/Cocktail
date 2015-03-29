package com.magie_pooh.mylibrary.debuger.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/**
 * Created by magie-pooh on 2015/03
 */
public class ShakeCallback implements SensorEventListener {

    @SuppressWarnings("unused")
    private static final String TAG = ShakeCallback.class.getSimpleName();

    private static final double THRESHOLD = 8;

    private final Callback mCallback;
    private double mPastData;

    public ShakeCallback(final Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != Sensor.TYPE_GYROSCOPE) {
            return;
        }

        final double resultant = getResultant(sensorEvent);
        if (mPastData > THRESHOLD && resultant < THRESHOLD) {
            mCallback.onShake();
        }
        mPastData = resultant;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // do nothing
    }

    private double getResultant(final SensorEvent sensorEvent) {
        return Math.sqrt(Math.pow(sensorEvent.values[0], 2)
                + Math.pow(sensorEvent.values[1], 2)) + Math.pow(sensorEvent.values[2], 2);
    }

    public interface Callback {
        public void onShake();
    }
}
