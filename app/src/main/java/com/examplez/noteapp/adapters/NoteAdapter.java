package com.examplez.noteapp.adapters;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.examplez.noteapp.databinding.ItemContainerNoteBinding;
import com.examplez.noteapp.databinding.ItemContainerNoteMainBinding;
import com.examplez.noteapp.entities.Note;
import com.examplez.noteapp.listeners.NoteListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class NoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Note> data;
    private NoteListener modelListener;
    private Timer timer;
    private List<Note> noteSource;
    private Boolean VIEW_TYPE_MAIN;

    public NoteAdapter(List<Note> data, NoteListener modelListener, Boolean isViewMain) {
        this.data = data;
        this.modelListener = modelListener;
        noteSource = data;
        VIEW_TYPE_MAIN = isViewMain;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (VIEW_TYPE_MAIN) {
            return new NoteViewHolderMain(
                    ItemContainerNoteMainBinding.inflate(
                            LayoutInflater.from(parent.getContext())
                            , parent
                            , false));


        } else {
            return new NoteViewHolder(
                    ItemContainerNoteBinding.inflate(
                            LayoutInflater.from(parent.getContext())
                            , parent
                            , false));
        }

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (VIEW_TYPE_MAIN) {
            ((NoteViewHolderMain) holder).setNoteData(data.get(position));
            ((NoteViewHolderMain) holder).binding.layoutNote.setOnClickListener(v -> modelListener.onNoteClicked(data.get(position), position));
        } else {
            ((NoteViewHolder) holder).setNoteData(data.get(position));
            ((NoteViewHolder) holder).binding.layoutNote.setOnClickListener(v -> modelListener.onNoteClicked(data.get(position), position));
        }
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

        public void setNoteData(Note model) {
            binding.textTitle.setText(model.getTitle());
            binding.textDateTime.setText(model.getDateTime());

            if (model.getImagePath() != null) {
                binding.imageNoteContainer.setImageBitmap(BitmapFactory.decodeFile(model.getImagePath()));
                binding.imageNoteContainer.setVisibility(View.VISIBLE);
            } else {
                binding.imageNoteContainer.setVisibility(View.GONE);
            }

            if (model.getSubtitle().trim().isEmpty()) {
                binding.textSubtitle.setVisibility(View.GONE);
            } else {
                binding.textSubtitle.setText(model.getSubtitle());


            }
            GradientDrawable gradientDrawable = (GradientDrawable) binding.layoutNote.getBackground();
            if (model.getColor() != null) {
                gradientDrawable.setColor(Color.parseColor(model.getColor()));
            } else {
                gradientDrawable.setColor(Color.parseColor("#333333"));
            }

        }
    }

    class NoteViewHolderMain extends RecyclerView.ViewHolder {
        ItemContainerNoteMainBinding binding;


        public NoteViewHolderMain(@NonNull ItemContainerNoteMainBinding itemContainerNoteMainBinding) {
            super(itemContainerNoteMainBinding.getRoot());
            binding = itemContainerNoteMainBinding;
        }
        public void setNoteData(Note model) {
            binding.noteTitle.setText(model.getTitle());
            binding.noteDate.setText(model.getDateTime());

            GradientDrawable gradientDrawable = (GradientDrawable) binding.viewSubtitleIndicator.getBackground();
            if (model.getColor() != null) {
                gradientDrawable.setColor(Color.parseColor(model.getColor()));
            } else {
                gradientDrawable.setColor(Color.parseColor("#333333"));
            }
        }
    }

    public void searchNotes(final String searchKeyWord) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (searchKeyWord.trim().isEmpty()) {
                    data = noteSource;
                } else {
                    ArrayList<Note> temp = new ArrayList<>();
                    for (Note note : noteSource) {
                        if (note.getTitle().toLowerCase().contains(searchKeyWord.toLowerCase())
                                || note.getTitle().toLowerCase().contains(searchKeyWord.toLowerCase())
                                || note.getSubtitle().toLowerCase().contains(searchKeyWord.toLowerCase())) {
                            temp.add(note);
                        }
                    }
                    data = temp;

                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        notifyDataSetChanged();


                    }
                });

            }
        }, 500);

    }

    public void cancelTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }
}
