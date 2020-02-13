package com.example.tabgoplayactivity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tabgoplayactivity.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SectionListChoiceAdapter extends RecyclerView.Adapter<SectionListChoiceAdapter.RowHolder> {
    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_section_choice,null,false);
        RowHolder rowHolder = new RowHolder(v);
        return rowHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        protected ImageView imageChoice;
        protected TextView singleTextChoice;
        public RowHolder(@NonNull View itemView) {
            super(itemView);
            imageChoice = itemView.findViewById(R.id.single_image_choice);
            singleTextChoice = itemView.findViewById(R.id.single_text_choice);
        }
    }
}
