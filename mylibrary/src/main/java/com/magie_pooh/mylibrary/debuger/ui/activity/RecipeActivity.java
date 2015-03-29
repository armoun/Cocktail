package com.magie_pooh.mylibrary.debuger.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

import com.magie_pooh.mylibrary.debuger.model.dto.PrefData;
import com.magie_pooh.mylibrary.debuger.ui.fragment.RecipeFragment;

/**
 * Created by magie-pooh on 2015/03
 */
public class RecipeActivity extends ActionBarActivity {

    @SuppressWarnings("unused")
    private static final String TAG = RecipeActivity.class.getSimpleName();

    private static final String ACTION = "action_shake";
    private static final String KEY_ACTIVITY_NAME = "key_activity";
    private static final int REQUEST_PREF_CHANGE = 101;

    public static void startActivity(final Context context) {
        final Intent intent = new Intent(context, RecipeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            final FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(android.R.id.content, RecipeFragment.newInstance())
                    .commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PREF_CHANGE) {
            final Fragment fragment = getSupportFragmentManager().findFragmentById(android.R.id
                    .content);
            if (!(fragment instanceof RecipeFragment)) {
                return;
            }
            ((RecipeFragment) fragment).refresh();
        }
    }

    public void startRecipePrefActivity(final PrefData dto) {
        RecipePrefActivity.startActivityForResult(this, REQUEST_PREF_CHANGE, dto);
    }

}
