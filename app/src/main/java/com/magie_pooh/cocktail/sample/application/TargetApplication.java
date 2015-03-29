package com.magie_pooh.cocktail.sample.application;

import android.app.Application;

import com.magie_pooh.mylibrary.debuger.Cocktail;

/**
 * Created by magie-pooh on 2015/03
 */
public class TargetApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // call here when debugging
        Cocktail.base(this);
    }
}
