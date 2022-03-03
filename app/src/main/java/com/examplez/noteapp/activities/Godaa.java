package com.examplez.noteapp.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.examplez.noteapp.R;
import com.examplez.noteapp.utilities.Constants;
import com.examplez.noteapp.utilities.PreferencesManager;

public class Godaa extends AppCompatActivity {
    public static void getTheme(Context context) {
        PreferencesManager preferencesManager = new PreferencesManager(context);
        Boolean themeBoolean = preferencesManager.getBoolean(Constants.THEME_BOOLEAN);
        if (themeBoolean) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            context.setTheme(R.style.Theme_Night);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            context.setTheme(R.style.Theme_Light);
        }
    }

    public static void openActivity(Context context, Class<?> activity) {
        Intent intent = new Intent(context, activity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


}
