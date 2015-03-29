package com.magie_pooh.mylibrary.debuger.ui.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magie_pooh.mylibrary.R;

/**
 * Created by magie-pooh on 2015/03
 */
public final class RecipePrefFileHeader extends AbstractListItem<RecipeType> {

    private static final String KEY_DTO = "key_dto";

    private RecipePrefFileHeader(Activity activity, ItemArgs args) {
        super(activity, RecipeType.PREF_HEADER_FILE, args);
    }

    public static RecipePrefFileHeader create(final Activity activity, final String fileName) {
        return new RecipePrefFileHeader(activity, new ItemArgs().putArg(KEY_DTO, fileName));
    }

    @Override
    protected View createView(ViewGroup parent) {
        return inflate(R.layout.item_fragment_recipe_pref_file_header, parent);
    }

    @Override
    protected ViewHolder createViewHolder(View v) {
        return new ItemViewHolder(v);
    }

    @Override
    protected void initView(int position, ViewHolder viewHolder) {
        final ItemViewHolder holder = (ItemViewHolder) viewHolder;
        holder.mFileName.setText(getArgs().getStringArg(KEY_DTO));
    }

    private static final class ItemViewHolder implements ViewHolder {
        private final TextView mFileName;

        private ItemViewHolder(final View v) {
            mFileName = (TextView) v.findViewById(R.id
                    .item_fragment_recipe_pref_file_header);
        }

    }
}
