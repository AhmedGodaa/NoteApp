package com.examplez.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.examplez.noteapp.databinding.ActivitySettingBinding;
import com.examplez.noteapp.utilities.Constants;
import com.examplez.noteapp.utilities.PreferencesManager;

import java.util.prefs.PreferenceChangeEvent;

public class SettingsActivity extends AppCompatActivity {
    private ActivitySettingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Godaa.getTheme(SettingsActivity.this);
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        PreferencesManager preferencesManager = new PreferencesManager(getApplicationContext());
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            binding.switch1.setChecked(true);

        } else {
            binding.switch1.setChecked(false);
        }
        binding.switch1.setOnCheckedChangeListener((a, b) -> {
            if (b) {
                preferencesManager.putBoolean(Constants.THEME_BOOLEAN, true);
                Godaa.getTheme(getApplicationContext());


            } else {
                preferencesManager.putBoolean(Constants.THEME_BOOLEAN, false);
                Godaa.getTheme(getApplicationContext());


            }
        });


    }
}