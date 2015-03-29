package com.magie_pooh.mylibrary.debuger.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.magie_pooh.mylibrary.debuger.model.dto.PrefData;
import com.magie_pooh.mylibrary.debuger.ui.fragment.RecipePrefFragment;

/**
 * Created by magie-pooh on 2015/03
 */
public class RecipePrefActivity extends FragmentActivity {

    private static final String KEY_DTO = "key_dto";

    public static void startActivity(final Context context, final PrefData dto) {
        final Intent intent = new Intent(context, RecipePrefActivity.class);
        intent.putExtra(KEY_DTO, dto);
        context.startActivity(intent);
    }

    public static void startActivityForResult(final Activity activity,
                                              final int requestCode, final PrefData dto) {
        final Intent intent = new Intent(activity, RecipePrefActivity.class);
        intent.putExtra(KEY_DTO, dto);
        activity.startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, RecipePrefFragment.newInstance(
                            (PrefData) getIntent().getParcelableExtra(KEY_DTO)))
                    .commit();
        }
    }
}
