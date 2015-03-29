package com.magie_pooh.mylibrary.debuger.ui.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.lang.ref.WeakReference;
import java.util.EnumSet;

/**
 * Created by magie-pooh on 2015/03
 */
public class AbstractListAdapter<E extends Enum<?>> extends ArrayAdapter<AbstractListItem<E>> {

    @SuppressWarnings("unused")
    private static final String TAG = AbstractListAdapter.class.getSimpleName();

    private final WeakReference<Activity> mActivity;

    private final int mSizeOfType;

    @SuppressWarnings({
            "unchecked", "rawtypes"
    })
    protected AbstractListAdapter(final Activity activity, final Class<? extends Enum> typeClass) {
        super(activity, 0);
        mActivity = new WeakReference<Activity>(activity);
        mSizeOfType = EnumSet.allOf(typeClass).size();
    }

    @Override
    public final int getViewTypeCount() {
        return mSizeOfType;
    }

    @Override
    public final int getItemViewType(final int position) {
        return getItem(position).getType().ordinal();
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        return getItem(position).getView(position, convertView, parent);
    }

    public void performItemClick(final int position, final Object object) {
        getItem(position).onItemClick(object);
    }

    public final Activity getActivity() {
        return mActivity.get();
    }
}
