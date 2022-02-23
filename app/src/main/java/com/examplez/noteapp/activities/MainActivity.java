package com.examplez.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;

import com.examplez.noteapp.R;
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
    private int noteClickedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
        setRecyclerView();

        binding.inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                noteAdapter.cancelTimer();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (noteList.size() != 0) {
                    noteAdapter.searchNotes(editable.toString());
                }
            }
        });

    }


    private void setRecyclerView() {
        noteList = new ArrayList<>();
        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, notes -> {
            noteList = notes;
            noteAdapter = new NoteAdapter(notes, this);
            binding.notesRecyclerView.setAdapter(noteAdapter);
            binding.notesRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        });
    }

    private void setListeners() {
        binding.imageAddNoteMain.setOnClickListener(v -> openActivity(this, CreateNoteActivity.class));

    }

    private void openActivity(Context context, Class activity) {
        Intent intent = new Intent(context, activity);
        startActivity(intent);

    }


    @Override
    public void onNoteClicked(Note note, int position) {
        noteClickedPosition = position;
        LinearLayout layoutNote = findViewById(R.id.layoutNote);
        Intent intent = new Intent(getApplicationContext(), CreateNoteActivity.class);
        intent.putExtra("isViewOrUpdate", true);
        intent.putExtra("note", note);

        Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<View, String>(layoutNote.findViewById(R.id.imageNoteContainer), "imageTransition");
        pairs[1] = new Pair<View, String>(layoutNote.findViewById(R.id.imageNoteContainer), "titleTransition");
        pairs[2] = new Pair<View, String>(layoutNote.findViewById(R.id.imageNoteContainer), "subtitleTransition");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
        startActivity(intent, options.toBundle());


    }


}