package com.examplez.noteapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.examplez.noteapp.activities.Godaa.Companion.getTheme
import com.examplez.noteapp.databinding.ActivitySettingBinding
import com.examplez.noteapp.utilities.Constants
import com.examplez.noteapp.utilities.PreferencesManager

class SettingsActivity : AppCompatActivity() {
    private var binding: ActivitySettingBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        getTheme(this@SettingsActivity)
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val preferencesManager = PreferencesManager(applicationContext)
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            binding!!.switch1.setChecked(true)
        } else {
            binding!!.switch1.setChecked(false)
        }
        binding!!.switch1.setOnCheckedChangeListener { v ->
            if (v) {
                preferencesManager.putBoolean(
                    Constants.THEME_BOOLEAN,
                    true
                )
                getTheme(applicationContext)
            } else {
                preferencesManager.putBoolean(
                    Constants.THEME_BOOLEAN,
                    false
                )
                getTheme(applicationContext)
            }
        }
    }
}