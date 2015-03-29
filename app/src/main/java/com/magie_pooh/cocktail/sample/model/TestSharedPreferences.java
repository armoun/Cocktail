package com.magie_pooh.cocktail.sample.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by magie-pooh on 2015/03
 */
public class TestSharedPreferences {

    private static final String NAME = "testPref";

    private static final String KEY_DATA = "key3";
    private static final String KEY_DATA2 = "key4";

    public void putData(final Context context, final String data) {
        final SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        editor.putString(KEY_DATA, data);
        editor.putString(KEY_DATA2, "hoge");
        editor.putBoolean("isConnect", true);
        editor.putFloat("time", 123456f);
        editor.putInt("int key", 111111111);
        editor.putLong("longkey", 1234567L);
        editor.commit();
    }

    public String getData(final Context context) {
        final SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return pref.getString(KEY_DATA, "");
    }
}
