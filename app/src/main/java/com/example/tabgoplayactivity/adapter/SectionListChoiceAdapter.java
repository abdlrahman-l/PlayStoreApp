package com.example.tabgoplayactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.model.ChoiceModel;
import com.example.tabgoplayactivity.model.SectionChoiceModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SectionListChoiceAdapter extends RecyclerView.Adapter<SectionListChoiceAdapter.RowHolder> {

    private ArrayList<ChoiceModel> choiceList;
    private Context mContext;

    public SectionListChoiceAdapter(ArrayList<ChoiceModel> choiceList, Context mContext) {
        this.choiceList = choiceList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_section_choice,null);
        RowHolder rowHolder = new RowHolder(v);
        return rowHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        ChoiceModel choice = choiceList.get(position);
        holder.singleTextChoice.setText(choice.getHeaderChoice());
        IconListChoiceAdapter adapter = new IconListChoiceAdapter(choice.getGameChoiceList(),mContext);
        holder.iconAppChoice.setHasFixedSize(true);
        holder.iconAppChoice.setLayoutManager(new LinearLayoutManager(mContext,RecyclerView.HORIZONTAL,false));
        holder.iconAppChoice.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return (null != choiceList ? choiceList.size() : 0);
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        protected RecyclerView iconAppChoice;
        protected ImageView imageChoice;
        protected TextView singleTextChoice;
        public RowHolder(@NonNull View itemView) {
            super(itemView);
            this.imageChoice = itemView.findViewById(R.id.single_image_choice);
            this.singleTextChoice = itemView.findViewById(R.id.single_text_choice);
            this.iconAppChoice = itemView.findViewById(R.id.recycler_list_app);
        }
    }
}
