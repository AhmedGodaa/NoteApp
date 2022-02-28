package com.examplez.noteapp.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

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
    NoteViewModel noteViewModel;
    int noteClickedPosition = -1;
    private AlertDialog addNoteDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Godaa.implementTheme(MainActivity.this);
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


    private void showAddNoteDialog() {
        if (addNoteDialog == null) {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            View view = LayoutInflater.from(this).inflate(R.layout.layout_add_note, findViewById(R.id.layoutDeleteNoteContainer));
            builder.setView(view);
            addNoteDialog = builder.create();

            if (addNoteDialog.getWindow() != null) {
                addNoteDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            }

            final LinearLayout startWriting = view.findViewById(R.id.layoutStartWriting);
            final LinearLayout chooseTemplate = view.findViewById(R.id.layoutChooseTemplate);
            startWriting.requestFocus();
            chooseTemplate.requestFocus();


            view.findViewById(R.id.layoutStartWriting).setOnClickListener(v -> {
                Toast.makeText(MainActivity.this, "Start Writing", Toast.LENGTH_SHORT).show();
                addNoteDialog.dismiss();

            });

            view.findViewById(R.id.layoutChooseTemplate).setOnClickListener(v -> {
                Toast.makeText(MainActivity.this, "Choose Template", Toast.LENGTH_SHORT).show();
                addNoteDialog.dismiss();

            });


        }
        addNoteDialog.show();

    }


    private void setListeners() {
//        binding.imageAddNoteMain.setOnClickListener(v -> openActivity(this, CreateNoteActivity.class));
        binding.addNoteMain.setOnClickListener(v -> showAddNoteDialog());
    }

    private void setRecyclerView() {
        noteList = new ArrayList<>();
        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, notes -> {
            noteList = notes;
            noteAdapter = new NoteAdapter(notes, this, true);
            binding.notesRecyclerView.setAdapter(noteAdapter);
            binding.notesRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
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