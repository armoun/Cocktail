package com.magie_pooh.cocktail.sample.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magie_pooh.cocktail.sample.R;
import com.magie_pooh.cocktail.sample.model.TestSharedPreferences;
import com.magie_pooh.cocktail.sample.model.UserInfoPreferences;
import com.magie_pooh.cocktail.sample.ui.activity.SubOneActivity;

public class TargetFragment extends Fragment implements View.OnClickListener {

    @SuppressWarnings("unused")
    private static final String TAG = TargetFragment.class.getSimpleName();

    public static TargetFragment newInstance() {
        return new TargetFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_target, container, false);
        rootView.findViewById(R.id.fragment_target_start).setOnClickListener(this);
        rootView.findViewById(R.id.fragment_target_stop).setOnClickListener(this);
        rootView.findViewById(R.id.fragment_target_save_pref).setOnClickListener(this);
        rootView.findViewById(R.id.fragment_target_delete_pref).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_target_start:
                SubOneActivity.startActivity(getActivity());
                break;
            case R.id.fragment_target_stop:
                break;
            case R.id.fragment_target_save_pref:
                new TestSharedPreferences().putData(getActivity(), String.valueOf(Math.random()));
                new UserInfoPreferences().putData(getActivity());
                break;
            case R.id.fragment_target_delete_pref:
                Log.v(TAG, new TestSharedPreferences().getData(getActivity()));
                break;
            default:
                break;
        }
    }
}
