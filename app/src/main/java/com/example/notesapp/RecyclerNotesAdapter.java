package com.example.notesapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.Models.Notes;

import java.util.ArrayList;

public class RecyclerNotesAdapter extends RecyclerView.Adapter<RecyclerNotesAdapter.ViewHolder> {
    Context context;
    ArrayList<Notes> arrNotes = new ArrayList<Notes>();

    RecyclerNotesAdapter(Context context, ArrayList<Notes> arrNotes){
        this.context = context;
        this.arrNotes = arrNotes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTitle.setText(arrNotes.get(position).getTitle());
        holder.txtNote.setText(arrNotes.get(position).getNote());

        holder.llrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, NoteActivity.class);
                i.putExtra("id", arrNotes.get(position).getId());
                i.putExtra("title", arrNotes.get(position).getTitle());
                i.putExtra("note", arrNotes.get(position).getNote());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtNote;
        LinearLayout llrow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.txtTitle);
            txtNote=itemView.findViewById(R.id.txtNote);
            llrow = itemView.findViewById(R.id.llRow);
        }
    }
}
