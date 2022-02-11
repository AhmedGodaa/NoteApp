package com.examplez.noteapp.acitivies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.examplez.noteapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    public static final int REQUEST_CODE_ADD_NOTE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageAddNoteMain.setOnClickListener(v -> {

            startActivityForResult ( new Intent(this, CreateNoteActivity.class),REQUEST_CODE_ADD_NOTE);

         });

    }


}