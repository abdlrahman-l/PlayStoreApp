package com.example.tabgoplayactivity.adapter;

import android.content.Context;
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

    private ArrayList<SingleGameModel> listGames;
    private Context mContext;

    public IconListChoiceAdapter(ArrayList<SingleGameModel> listGames, Context mContext) {
        this.listGames = listGames;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_icon_choice,null);
        RowHolder rowHolder = new RowHolder(v);
        return rowHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
//        holder.iconImage.setImageResource(listGames.get(position).getGameIcon());
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
