package com.examplez.noteapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;


import com.examplez.noteapp.databinding.ItemContainerNoteBinding;
import com.examplez.noteapp.entities.Note;
import com.examplez.noteapp.listeners.NoteListener;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private List<Note> data;
    private NoteListener modelListener;

    public NoteAdapter(List<Note> data, NoteListener modelListener) {
        this.data = data;
        this.modelListener = modelListener;
    }

    public NoteAdapter(List<Note> data) {
        this.data = data;

    }
    public void setNotes(List<Note> notes){
        data = notes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContainerNoteBinding binding = ItemContainerNoteBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false);


        return new NoteViewHolder(binding);

    }


    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note model = data.get(position);

        holder.setNoteData(data.get(position), position);
    }

    @Override
    public int getItemViewType(int position) {
        return position;

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        ItemContainerNoteBinding binding;


        public NoteViewHolder(@NonNull ItemContainerNoteBinding itemContainerNoteBinding) {
            super(itemContainerNoteBinding.getRoot());
            binding = itemContainerNoteBinding;


        }

        public void setNoteData(Note model, int position) {
            binding.textTitle.setText(model.getTitle());
            binding.textDateTime.setText(model.getDateTime());

            if (model.getSubtitle().trim().isEmpty()) {
                binding.textSubtitle.setVisibility(View.GONE);
            } else {
                binding.textSubtitle.setText(model.getSubtitle());


            }

        }
    }
}
