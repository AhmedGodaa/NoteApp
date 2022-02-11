package com.examplez.noteapp.acitivies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.examplez.noteapp.databinding.ActivityCreateNoteBinding;
import com.examplez.noteapp.entities.Note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CreateNoteActivity extends AppCompatActivity {
    private ActivityCreateNoteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imageBack.setOnClickListener(v -> onBackPressed());
        binding.textDateTime.setText(new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm a", Locale.getDefault()).format(new Date()));
    }

    private void saveNote() {
        if (binding.inputNoteTitle.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please Enter Note Title", Toast.LENGTH_SHORT).show();
            return;
        } else {
            if (binding.inputNoteSubtitle.getText().toString().trim().isEmpty()
                    && binding.inputNoteText.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Note can't be empty!", Toast.LENGTH_SHORT).show();
                return;
            }
            final Note note = new Note();
            note.setTitle(binding.inputNoteTitle.toString());
            note.setSubtitle(binding.inputNoteSubtitle.toString());
            note.setNoteText(binding.inputNoteText.toString());

        }
    }
}