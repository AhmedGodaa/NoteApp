package com.examplez.noteapp.presentation.settings

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.examplez.noteapp.common.Godaa.Companion.getTheme
import com.examplez.noteapp.databinding.ActivitySettingBinding
import com.examplez.noteapp.common.Constants
import com.examplez.noteapp.common.PreferencesManager
import com.examplez.noteapp.presentation.signin.SignInActivity

class SettingsActivity : AppCompatActivity() {
    private var binding: ActivitySettingBinding? = null
    private var preferencesManager: PreferencesManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        getTheme(this@SettingsActivity)
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        preferencesManager =
            PreferencesManager(applicationContext)
        changeMode()
        setListeners()


    }

    private fun setListeners() {
        binding?.textSignOut?.setOnClickListener {
            preferencesManager?.clear()
            preferencesManager?.putBoolean(Constants.KEY_IS_SIGNED_IN, false)
            val intent = Intent(this, SignInActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()

        }

    }

    private fun changeMode() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            binding!!.switch1.setChecked(true)
        } else {
            binding!!.switch1.setChecked(false)
        }
        binding!!.switch1.setOnCheckedChangeListener { v ->
            if (v) {
                preferencesManager?.putBoolean(
                    Constants.THEME_BOOLEAN,
                    true
                )
                getTheme(applicationContext)
            } else {
                preferencesManager?.putBoolean(
                    Constants.THEME_BOOLEAN,
                    false
                )
                getTheme(applicationContext)
            }
        }
    }
}