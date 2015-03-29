package com.magie_pooh.mylibrary.debuger.model;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by magie-pooh on 2015/03
 */
public class CurrentActivityObserver implements Application.ActivityLifecycleCallbacks {

    private static final String TAG = CurrentActivityObserver.class.getSimpleName();

    private WeakReference<Activity> mActivity;

    @Nullable
    public Activity getActivity() {
        return mActivity == null ? null : mActivity.get();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
//        Log.d(TAG, "onActivityCreated:" + activity.toString());
    }

    @Override
    public void onActivityStarted(Activity activity) {
//        Log.d(TAG, "onActivityStarted:" + activity.toString());
//        mActivity = new WeakReference<Activity>(activity);
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.d(TAG, "==onActivityResumed:" + activity.getClass().getSimpleName());
        mActivity = new WeakReference<Activity>(activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.d(TAG, "==onActivityPaused:" + activity.getClass().getSimpleName());
        mActivity = null;
    }

    @Override
    public void onActivityStopped(Activity activity) {
//        Log.d(TAG, "onActivityStopped:" + activity.toString());
//        mActivity = null;
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
//        Log.d(TAG, "onActivitySaveInstanceState:" + activity.toString());
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
//        Log.d(TAG, "onActivityDestroyed:" + activity.toString());
    }
}
