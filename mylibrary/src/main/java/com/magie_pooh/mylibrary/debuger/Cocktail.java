package com.magie_pooh.mylibrary.debuger;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.Nullable;

import com.magie_pooh.mylibrary.debuger.model.CurrentActivityObserver;
import com.magie_pooh.mylibrary.debuger.ui.notification.ControllerNotification;


/**
 * Created by magie-pooh on 2015/03
 * TODO manage notification from service
 */
public class Cocktail {

    private static CurrentActivityObserver mActivityObserver;

    public static void base(final Application application) {
        ControllerNotification.show(application);
        application.registerActivityLifecycleCallbacks(getObserverInstance());
    }

    private static CurrentActivityObserver getObserverInstance() {
        if (mActivityObserver == null) {
            mActivityObserver = new CurrentActivityObserver();
        }
        return mActivityObserver;
    }

    @Nullable
    public static Activity getCurrentActivity() {
        return mActivityObserver == null ? null : mActivityObserver.getActivity();
    }
}
