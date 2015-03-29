package com.magie_pooh.mylibrary.debuger.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.magie_pooh.mylibrary.R;
import com.magie_pooh.mylibrary.debuger.model.SharedPreferenceManager;
import com.magie_pooh.mylibrary.debuger.model.dto.PrefData;

/**
 * Created by magie-pooh on 2015/03
 */
public class RecipePrefFragment extends Fragment implements View.OnClickListener {

    @SuppressWarnings("unused")
    private static final String TAG = RecipePrefFragment.class.getSimpleName();

    private static final String KEY_DTO = "key_original_dto";

    private TextView mOriginalKey;
    private TextView mOriginalValue;
    private EditText mEditTextValue;

    public static RecipePrefFragment newInstance(final PrefData dto) {
        final RecipePrefFragment f = new RecipePrefFragment();
        final Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_DTO, dto);
        f.setArguments(bundle);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_recipe_pref, container, false);
        mOriginalKey = ((TextView) v.findViewById(R.id.fragment_recipe_pref_original_key));
        mOriginalValue = ((TextView) v.findViewById(R.id.fragment_recipe_pref_original_value));
        mEditTextValue = (EditText) v.findViewById(R.id.fragment_recipe_pref_edit_value);
        v.findViewById(R.id.fragment_recipe_pref_cancel).setOnClickListener(this);
        v.findViewById(R.id.fragment_recipe_pref_save).setOnClickListener(this);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final PrefData dto = getArguments().getParcelable(KEY_DTO);
        mOriginalKey.setText(dto.key);
        mOriginalValue.setText(dto.value);
        mEditTextValue.setText(dto.value);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.fragment_recipe_pref_save) {
            onClickSave();
        } else if (i == R.id.fragment_recipe_pref_cancel) {
            onClickCancel();
        }
    }

    private void onClickSave() {
        final Activity activity = getActivity();
        final PrefData dto = getArguments().getParcelable(KEY_DTO);
        final boolean result = new SharedPreferenceManager().writePreference(activity, dto,
                mEditTextValue.getText().toString());
        activity.setResult(Activity.RESULT_OK);
        activity.finish();
    }

    private void onClickCancel() {
        final Activity activity = getActivity();
        activity.setResult(Activity.RESULT_CANCELED);
        activity.finish();
    }
}
