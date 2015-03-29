package com.magie_pooh.cocktail.sample.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.magie_pooh.cocktail.sample.R;

/**
 * Created by magie-pooh on 2015/03
 */
public class SubOneActivity extends ActionBarActivity {

    @SuppressWarnings("unused")
    private static final String TAG = SubOneActivity.class.getSimpleName();

    public static void startActivity(final Context context) {
        final Intent intent = new Intent(context, SubOneActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_one);
    }
}
