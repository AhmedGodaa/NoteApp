package com.examplez.noteapp.utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {
    SharedPreferences sharedPreferences;

    public PreferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences(Constants.KEY_THEME, Context.MODE_PRIVATE);

    }

    public void putBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }


    public Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }
}
