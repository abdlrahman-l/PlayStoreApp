package com.example.tabgoplayactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.model.ChoiceModel;
import com.example.tabgoplayactivity.model.SectionChoiceModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EditorChoiceRv extends RecyclerView.Adapter<EditorChoiceRv.RowHolder> {

    private Context mContext;
    private ArrayList<SectionChoiceModel> listSectionChoice;

    public EditorChoiceRv(Context mContext, ArrayList<SectionChoiceModel> listSectionChoice) {
        this.mContext = mContext;
        this.listSectionChoice = listSectionChoice;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_editor_choice,null,false);
        RowHolder rowHolder = new RowHolder(v);
        return rowHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.rvChoice.setLayoutManager(new LinearLayoutManager(mContext,RecyclerView.VERTICAL,false));
        holder.rvChoice.setHasFixedSize(true);
        SectionListChoiceAdapter adapter = new SectionListChoiceAdapter(listSectionChoice,mContext);
        holder.rvChoice.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RowHolder extends RecyclerView.ViewHolder {

        protected TextView titleSection;
        protected RecyclerView rvChoice;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
            rvChoice = itemView.findViewById(R.id.rv_section_choice);
            titleSection = itemView.findViewById(R.id.title_section_choice);
        }
    }
}
