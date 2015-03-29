package com.magie_pooh.mylibrary.debuger.ui.adapter;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

/**
 * Created by magie-pooh on 2015/03
 */
public abstract class AbstractListItem<E extends Enum<?>> {

    @SuppressWarnings("unused")
    private static final String TAG = AbstractListItem.class.getSimpleName();

    private final Application mApp;
    private final WeakReference<Activity> mActivity;
    private final E mType;
    private final ItemArgs mItemArgs;
    private boolean mIsAttachToRoot = false;

    public AbstractListItem(final Activity activity, final E type, final ItemArgs args) {
        mApp = activity.getApplication();
        mActivity = new WeakReference<Activity>(activity);
        mType = type;
        mItemArgs = args;
    }

    public AbstractListItem(final Activity activity, final E type) {
        this(activity, type, (ItemArgs) null);
    }

    protected Application getApp() {
        return mApp;
    }

    protected final Activity getActivity() {
        return mActivity.get();
    }

    @SuppressWarnings("unchecked")
    public final <T extends ItemArgs> T getArgs() {
        return (T) mItemArgs;
    }

    public final E getType() {
        return mType;
    }

    protected final View inflate(final int res, final ViewGroup parent) {
        final Activity activity = getActivity();
        if (activity == null) {
            return null;
        }

        return activity.getLayoutInflater().inflate(res, parent, mIsAttachToRoot);
    }

    public View getView(final int position, final View convertView, final ViewGroup parent) {
        final View v;
        if (convertView == null) {
            v = createView(parent);
            final ViewHolder holder = createViewHolder(v);
            v.setTag(holder);
        } else {
            v = convertView;
        }

        initView(position, (ViewHolder) v.getTag());
        return v;
    }

    protected abstract View createView(final ViewGroup parent);

    protected abstract ViewHolder createViewHolder(View v);

    protected abstract void initView(final int position, final ViewHolder viewHolder);

    protected void onItemClick(Object object) {

    }

    public interface ViewHolder {

    }
}
