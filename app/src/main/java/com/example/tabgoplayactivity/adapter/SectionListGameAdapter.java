package com.example.tabgoplayactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.model.SingleGameModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SectionListGameAdapter extends RecyclerView.Adapter<SectionListGameAdapter.SingleGameRowHolder> {

    private ArrayList<SingleGameModel> gameList;
    private Context mContext;

    public SectionListGameAdapter(ArrayList<SingleGameModel> gameList, Context mContext) {
        this.gameList = gameList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SingleGameRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_game,null);
        SingleGameRowHolder singleGameRowHolder = new SingleGameRowHolder(v);
        return singleGameRowHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SingleGameRowHolder holder, int position) {
        SingleGameModel singleGame = gameList.get(position);
        holder.gameName.setText(gameList.get(position).getGameName());
        holder.gameRating.setText(String.valueOf(gameList.get(position).getGameRating()));
    }

    @Override
    public int getItemCount() {
        return (null != gameList ? gameList.size() : 0);
    }

    public class SingleGameRowHolder extends RecyclerView.ViewHolder {
        protected TextView gameName;
        protected TextView gameRating;

        public SingleGameRowHolder(@NonNull View itemView) {
            super(itemView);
            this.gameName = itemView.findViewById(R.id.game_title);
            this.gameRating = itemView.findViewById(R.id.game_rate);
        }
    }
}
