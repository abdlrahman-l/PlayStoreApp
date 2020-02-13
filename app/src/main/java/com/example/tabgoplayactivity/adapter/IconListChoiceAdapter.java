package com.example.tabgoplayactivity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.model.SingleGameModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IconListChoiceAdapter extends RecyclerView.Adapter<IconListChoiceAdapter.RowHolder> {

    ArrayList<SingleGameModel> listGames;

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_icon_choice,null,false);
        RowHolder rowHolder = new RowHolder(v);
        return rowHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
//        holder.iconImage.setImageResource();
    }

    @Override
    public int getItemCount() {
        return (null != listGames ? listGames.size() : 0);
    }

    public class RowHolder extends RecyclerView.ViewHolder {

        protected ImageView iconImage;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.image_icon_choice);
        }
    }
}
