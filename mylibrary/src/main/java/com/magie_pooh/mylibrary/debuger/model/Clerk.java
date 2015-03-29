package com.magie_pooh.mylibrary.debuger.model;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import com.magie_pooh.mylibrary.debuger.Cocktail;
import com.magie_pooh.mylibrary.debuger.model.dto.PrefData;

import java.util.List;

/**
 * Created by magie-pooh on 2015/03
 */
public class Clerk {

    @SuppressWarnings("unused")
    private static final String TAG = Clerk.class.getSimpleName();

    private final SharedPreferenceManager mPrefManager;

    public Clerk() {
        mPrefManager = new SharedPreferenceManager();
    }

    public String message(final Context context) {
//        return getTopActivityName(context);
        return getTopActivityName();
    }

    public List<PrefData> getPreferenceData(final Context context) {
        return mPrefManager.getPreferenceData(context);
    }

    private String getTopActivityName() {
        final Activity activity = Cocktail.getCurrentActivity();
        return activity == null ? "" : activity.getClass().getSimpleName();
    }

    private String getTopActivityName(final Context context) {
        final ActivityManager am = (ActivityManager) context.getSystemService
                (Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(3);
        if (list == null || list.size() == 0) {
            return null;
        }
        for (final ActivityManager.RunningTaskInfo info : list) {
            Log.v(TAG, "info:" + info.numActivities + ", " + info.topActivity.getShortClassName());
        }
        return list.get(0).topActivity.getShortClassName();
    }
}
