package com.magie_pooh.cocktail.sample.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by magie-pooh on 2015/03
 */
public class UserInfoPreferences {
    private static final String NAME = "userInfo";

    private static final String KEY_NAME = "key_name";
    private static final String KEY_AGE = "key_age";
    private static final String KEY_LIKE = "key_like";
    private static final String KEY_CAN_DRING = "key_can_drink";

    public void putData(final Context context) {
        final SharedPreferences pref = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        editor.putString(KEY_NAME, "alice");
        editor.putString(KEY_LIKE, "Godfather");
        editor.putInt(KEY_AGE, 25);
        editor.putBoolean(KEY_CAN_DRING, true);
        editor.commit();
    }
}
