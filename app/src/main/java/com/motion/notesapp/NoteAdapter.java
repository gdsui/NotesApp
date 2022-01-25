package com.motion.notesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    List<Note> noteList;
    private OnNoteClickListener onNoteClickListener;

    public void setOnNoteClickListener(OnNoteClickListener onNoteClickListener) {
        this.onNoteClickListener = onNoteClickListener;
    }

    public NoteAdapter(List<Note> noteList) {
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_note,parent,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
     holder.bind(noteList.get(position));
        Note note=noteList.get(position);
        int colorId;
        int priority=note.getPriority();
        switch (priority){
            case 1:
                colorId=holder.itemView.getResources().getColor(R.color.purple_200);
                break;
            case 2:
                colorId=holder.itemView.getResources().getColor(R.color.purple_500);

                break;
            case 3:
                colorId=holder.itemView.getResources().getColor(R.color.purple_700);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + priority);
        }
        holder.tvTitle.setBackgroundColor(colorId);

    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvDesc,tvDayOfWeek,tvPriority;
    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }
     private void initViews(View itemView){
        tvTitle=itemView.findViewById(R.id.tv_title);
        tvDesc=itemView.findViewById(R.id.tv_desc);
        tvDayOfWeek=itemView.findViewById(R.id.tv_day_of_week);
        tvPriority=itemView.findViewById(R.id.tv_priority);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNoteClickListener.onNoteClick(getAdapterPosition());
                onNoteClickListener.onNoteLongClick(getAdapterPosition());
            }
        });
        }

        public void bind(Note note) {
            tvTitle.setText(note.getTitle());
            tvDesc.setText(note.getDescription());
            tvDayOfWeek.setText(note.getDayOfWeek());
            tvPriority.setText(String.valueOf(note.getPriority()));
        }
    }
}
