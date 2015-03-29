package com.magie_pooh.mylibrary.debuger.ui.adapter;

import android.os.Bundle;
import android.os.Parcelable;

/**
 * Created by magie-pooh on 2015/03
 */
public class ItemArgs {

    private final Bundle mArgs = new Bundle();

    public final <T extends Parcelable> T getParcelableArg(final String key) {
        return mArgs.getParcelable(key);
    }

    public final ItemArgs putArg(final String key, final Parcelable value) {
        mArgs.putParcelable(key, value);
        return this;
    }

    @SuppressWarnings({
            "rawtypes", "unchecked"
    })

    public final String getStringArg(final String key) {
        return mArgs.getString(key);
    }

    public final ItemArgs putArg(final String key, final String value) {
        mArgs.putString(key, value);
        return this;
    }
}
