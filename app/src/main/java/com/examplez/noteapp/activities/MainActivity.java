package com.examplez.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.examplez.noteapp.adapters.NoteAdapter;
import com.examplez.noteapp.databinding.ActivityMainBinding;
import com.examplez.noteapp.entities.Note;
import com.examplez.noteapp.listeners.NoteListener;
import com.examplez.noteapp.viewmodels.NoteViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NoteListener {
    private ActivityMainBinding binding;
    private List<Note> noteList;
    private NoteAdapter noteAdapter;
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
        setRecyclerView();
        newViewModel();

    }


    private void setRecyclerView() {
        noteList = new ArrayList<>();
        noteAdapter = new NoteAdapter(noteList, this);
        binding.notesRecyclerView.setAdapter(noteAdapter);
        binding.notesRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    private void newViewModel() {
        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, notes -> noteAdapter.setNotes(notes));
    }

    private void setListeners() {
        binding.imageAddNoteMain.setOnClickListener(v -> openActivity(this, CreateNoteActivity.class));

    }

    private void openActivity(Context context,Class activity) {
        Intent intent = new Intent(context, activity);
        startActivity(intent);

    }


    @Override
    public void onNoteClicked(Note note) {

    }


}