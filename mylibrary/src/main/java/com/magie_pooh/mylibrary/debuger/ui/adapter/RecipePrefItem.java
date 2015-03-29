package com.magie_pooh.mylibrary.debuger.ui.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magie_pooh.mylibrary.R;
import com.magie_pooh.mylibrary.debuger.model.dto.PrefData;
import com.magie_pooh.mylibrary.debuger.ui.activity.RecipeActivity;

/**
 * Created by magie-pooh on 2015/03
 */
public final class RecipePrefItem extends AbstractListItem<RecipeType> {

    @SuppressWarnings("unused")
    private static final String TAG = RecipePrefItem.class.getSimpleName();

    private static final String KEY_DTO = "key_dto";

    private RecipePrefItem(Activity activity, final ItemArgs args) {
        super(activity, RecipeType.PREF_ITEM, args);
    }

    public static RecipePrefItem create(Activity activity, final PrefData dto) {
        return new RecipePrefItem(activity, new ItemArgs().putArg(KEY_DTO, dto));
    }

    @Override
    protected View createView(ViewGroup parent) {
        return inflate(R.layout.item_fragment_recipe_pref_item, parent);
    }

    @Override
    public ViewHolder createViewHolder(View v) {
        return new ItemViewHolder(v);
    }

    @Override
    protected void initView(int position, ViewHolder viewHolder) {
        final ItemViewHolder holder = (ItemViewHolder) viewHolder;
        final PrefData dto = getDto();

        holder.mKey.setText(dto.key);
        holder.mValue.setText(dto.value);
    }

    @Override
    protected void onItemClick(Object object) {
        final Activity activity = getActivity();
        if (!(activity instanceof RecipeActivity)) {
            return;
        }
        ((RecipeActivity) activity).startRecipePrefActivity(getDto());
    }

    private PrefData getDto() {
        return getArgs().getParcelableArg(KEY_DTO);
    }

    private static final class ItemViewHolder implements ViewHolder {
        private final TextView mKey;
        private final TextView mValue;

        private ItemViewHolder(final View v) {
            mKey = (TextView) v.findViewById(R.id.item_fragment_recipe_pref_item_key);
            mValue = (TextView) v.findViewById(R.id.item_fragment_recipe_pref_item_value);
        }
    }
}
