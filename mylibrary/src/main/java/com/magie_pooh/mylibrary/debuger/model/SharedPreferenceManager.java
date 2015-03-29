package com.magie_pooh.mylibrary.debuger.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.magie_pooh.mylibrary.debuger.model.dto.PrefData;
import com.magie_pooh.mylibrary.debuger.model.dto.PrefType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by magie-pooh on 2015/03
 */
public class SharedPreferenceManager {

    @SuppressWarnings("unused")
    private static final String TAG = SharedPreferenceManager.class.getSimpleName();

    public List<PrefData> getPreferenceData(final Context context) {
        // TODO samsung path
        final File sharedPreferenceFile = new File("/data/data/" + context.getPackageName() +
                "/shared_prefs/");
        final File[] listFiles = sharedPreferenceFile.listFiles();
        final List<PrefData> result = new ArrayList<>();
        if (listFiles == null) {
            return result;
        }
        try {
            for (final File file : listFiles) {
                final BufferedReader br = new BufferedReader(new FileReader(file));
                final String fileName = trimFileName(file.getName());
                String line;
                while ((line = br.readLine()) != null) {
                    Log.v(TAG, line);
                    final PrefData dto = makePrefData(fileName, line);
                    if (dto != null) {
                        result.add(dto);
                    }
                }
                br.close();
            }
        } catch (final FileNotFoundException e) {
            Log.e(TAG, "cannot read shared preferences", e);
            result.clear();
            return result;
        } catch (IOException e) {
            Log.e(TAG, "cannot read shared preferences", e);
            result.clear();
            return result;
        }
        return result;
    }

    public boolean writePreference(final Context context, final PrefData oldPrefData,
                                   final String newValue) {
        if (oldPrefData == null || TextUtils.isEmpty(oldPrefData.fileName) || TextUtils.isEmpty
                (oldPrefData.key)) {
            return false;
        }
        // TODO check exist the file
        final SharedPreferences pref = context.getSharedPreferences(oldPrefData.fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        switch (oldPrefData.dataType) {
            case STRING:
                editor.putString(oldPrefData.key, newValue);
                break;
            case BOOLEAN:
                editor.putBoolean(oldPrefData.key, Boolean.valueOf(newValue));
                break;
            case FLOAT:
                editor.putFloat(oldPrefData.key, Float.valueOf(newValue));
                break;
            case INT:
                editor.putInt(oldPrefData.key, Integer.valueOf(newValue));
                break;
            case LONG:
                editor.putLong(oldPrefData.key, Long.valueOf(newValue));
                break;
            default:
                break;
        }
        editor.commit();
        return true;
    }

    private String trimFileName(final String fileName) {
        final String patternString = "(.*)\\.xml";
        final Matcher matcher = Pattern.compile(patternString).matcher(fileName);
        if (!matcher.matches()) {
            return "";
        }
        return matcher.group(1);
    }

    private PrefData makePrefData(final String fileName, final String line) {
        for (final PrefType type : PrefType.values()) {
            final Matcher matcher = Pattern.compile(type.mPattern).matcher(line);
            if (!matcher.matches()) {
                continue;
            }
            final PrefData dto = new PrefData();
            dto.fileName = fileName;
            dto.key = matcher.group(1);
            dto.value = matcher.group(2);
            dto.dataType = type;
            return dto;
        }
        return null;
    }

}
