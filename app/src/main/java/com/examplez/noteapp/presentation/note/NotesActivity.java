package com.examplez.noteapp.presentation.note;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.examplez.noteapp.common.Godaa;
import com.examplez.noteapp.databinding.ActivityNotesBinding;
import com.examplez.noteapp.domain.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesActivity extends AppCompatActivity implements NoteListener {
    private ActivityNotesBinding binding;
    private List<Note> noteList;
    private NoteAdapter noteAdapter;
    NoteViewModel noteViewModel;
    int noteClickedPosition = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Godaa.Companion.getTheme(NotesActivity.this);
        super.onCreate(savedInstanceState);
        binding = ActivityNotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setRecyclerView();
    }

    private void setRecyclerView() {
        noteList = new ArrayList<>();
        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, notes -> {
            noteList = notes;
            noteAdapter = new NoteAdapter(notes, this, false);
            binding.notesRecyclerView.setAdapter(noteAdapter);
            binding.notesRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        });
    }

    @Override
    public void onNoteClicked(Note note, int position) {
        noteClickedPosition = position;
        Intent intent = new Intent(getApplicationContext(), CreateNoteActivity.class);
        intent.putExtra("isViewOrUpdate", true);
        intent.putExtra("note", note);
        startActivity(intent);

    }
}