package com.example.mywordlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private Context context;
    private ArrayList word_id,meaning_id;

    public Adapter(Context context, ArrayList word_id, ArrayList meaning_id) {
        this.context = context;
        this.word_id = word_id;
        this.meaning_id = meaning_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.wordentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.word_id.setText(String.valueOf(word_id.get(position)));
        holder.meaning_id.setText(String.valueOf(meaning_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return word_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView word_id,meaning_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            word_id = itemView.findViewById(R.id.textword);
            meaning_id = itemView.findViewById(R.id.textmeaning);

        }
    }
}
