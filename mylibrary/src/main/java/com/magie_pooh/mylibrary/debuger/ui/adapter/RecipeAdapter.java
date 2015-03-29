package com.magie_pooh.mylibrary.debuger.ui.adapter;

import android.app.Activity;

/**
 * Created by magie-pooh on 2015/03
 */
public final class RecipeAdapter extends AbstractListAdapter<RecipeType> {

    public RecipeAdapter(Activity activity) {
        super(activity, RecipeType.class);
    }

}
