package com.magie_pooh.mylibrary.debuger.receiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by magie-pooh on 2015/03
 */
public abstract class DebuggerControlReceiver extends BroadcastReceiver {

    @SuppressWarnings("unused")
    private static final String TAG = DebuggerControlReceiver.class.getSimpleName();

    private static final String ACTION = "action_debugger_controll";

    public static Intent getBroadcastIntent() {
        final Intent intent = new Intent();
        intent.setAction(ACTION);
        return intent;
    }

    public static IntentFilter getIntentFilter() {
        final IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION);
        return filter;
    }
}
