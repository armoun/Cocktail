package com.magie_pooh.mylibrary.debuger.ui.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import com.magie_pooh.mylibrary.R;

/**
 * Created by magie-pooh on 2015/03
 */
public final class RecipePrefHeader extends AbstractListItem<RecipeType> {

    private RecipePrefHeader(Activity activity) {
        super(activity, RecipeType.PREF_HEADER);
    }

    public static final RecipePrefHeader create(final Activity activity) {
        return new RecipePrefHeader(activity);
    }

    @Override
    public ViewHolder createViewHolder(View v) {
        return null;
    }

    @Override
    protected void initView(int position, ViewHolder viewHolder) {
        // do nothing
    }

    @Override
    public View createView(ViewGroup parent) {
        return inflate(R.layout.item_fragment_recipe_pref_header, parent);
    }

    @Override
    protected void onItemClick(Object object) {

    }
}
