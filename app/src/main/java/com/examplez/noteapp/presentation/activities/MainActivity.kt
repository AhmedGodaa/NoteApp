package com.examplez.noteapp.presentation.activities

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.examplez.noteapp.R
import com.examplez.noteapp.common.Godaa
import com.examplez.noteapp.common.Godaa.Companion.openActivity
import com.examplez.noteapp.common.PreferencesManager
import com.examplez.noteapp.databinding.ActivityMainBinding
import com.examplez.noteapp.domain.model.Note
import com.examplez.noteapp.presentation.note.*
import com.examplez.noteapp.presentation.settings.SettingsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NoteListener {
    lateinit var binding: ActivityMainBinding
    private val noteList: List<Note> = ArrayList()
    lateinit var noteAdapter: NoteAdapter
    private val noteViewModel: NotesViewModel by viewModels()
    var noteClickedPosition = -1
    var addNoteDialog: AlertDialog? = null
    lateinit var preferencesManager: PreferencesManager


    override fun onCreate(savedInstanceState: Bundle?) {
        Godaa.getTheme(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferencesManager = PreferencesManager(this)
        noteViewModel = ViewModelProvider(this)[NotesViewModel::class.java]
        noteAdapter = NoteAdapter(noteList, this, true)
        setListeners()
        setRecyclerView()
        setSearch()


    }

    private fun setListeners() {
        binding.addNoteMain.setOnClickListener { showAddNoteDialog() }
        binding.imageAllNotes.setOnClickListener { openActivity(this, NotesActivity::class.java) }
        binding.imageView2.setOnClickListener { openActivity(this, SettingsActivity::class.java) }


    }

    private fun showAddNoteDialog() {
        if (addNoteDialog == null) {
            val builder = AlertDialog.Builder(this@MainActivity)
            val view = LayoutInflater.from(this)
                .inflate(R.layout.layout_add_note, findViewById(R.id.layoutDeleteNoteContainer))
            builder.setView(view)
            addNoteDialog = builder.create()

            if (addNoteDialog!!.window != null) {
                addNoteDialog!!.window!!.setBackgroundDrawable(ColorDrawable(0))
            }
            val startWriting = view.findViewById<LinearLayout>(R.id.layoutStartWriting)
            val chooseTemplate = view.findViewById<LinearLayout>(R.id.layoutChooseTemplate)
            startWriting.requestFocus()
            chooseTemplate.requestFocus()
            view.findViewById<LinearLayout>(R.id.layoutStartWriting).setOnClickListener {
                addNoteDialog!!.dismiss()
                openActivity(this, CreateNoteActivity::class.java)
            }
            view.findViewById<LinearLayout>(R.id.layoutChooseTemplate).setOnClickListener {
                Toast.makeText(this@MainActivity, "Choose Template", Toast.LENGTH_SHORT).show()
                addNoteDialog!!.dismiss()
            }


        }
        addNoteDialog!!.show()

    }

    private fun setSearch() {
        binding.inputSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                noteAdapter.cancelTimer()
            }

            override fun afterTextChanged(p0: Editable?) {
                if (noteList.isNotEmpty()) {
                    noteAdapter.searchNotes(p0.toString())
                }
            }
        })


    }

    private fun setRecyclerView() {
        noteViewModel.getNotes();
    }


    override fun onNoteClicked(note: Note?, position: Int) {
        TODO("Not yet implemented")
    }
}