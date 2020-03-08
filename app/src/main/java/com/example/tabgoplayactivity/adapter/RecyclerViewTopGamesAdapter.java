package com.example.tabgoplayactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.listener.ClickListener;
import com.example.tabgoplayactivity.model.SingleGameModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewTopGamesAdapter extends RecyclerView.Adapter<RecyclerViewTopGamesAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<SingleGameModel> topGamesList;
    private ClickListener listener;
    private int chipPosition = 0;

    public RecyclerViewTopGamesAdapter(Context mContext, ArrayList<SingleGameModel> topGamesList, ClickListener listener) {
        this.mContext = mContext;
        this.topGamesList = topGamesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_top_games,null);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SingleGameModel singleGame = topGamesList.get(position);
        holder.nameGame.setText(singleGame.getGameName());
        holder.numberPosition.setText(String.valueOf(position+1));
        holder.sizeGame.setText(singleGame.getGameSize());
        holder.ratingGame.setText(String.valueOf(String.valueOf(singleGame.getGameRating())));
    }

    @Override
    public int getItemCount() {
        return (null != topGamesList ? topGamesList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iconGame;
        protected TextView nameGame,ratingGame,sizeGame,numberPosition;
        protected WeakReference<ClickListener> listenerRef;
        protected LinearLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconGame = itemView.findViewById(R.id.image_game);
            nameGame = itemView.findViewById(R.id.title_game);
            ratingGame = itemView.findViewById(R.id.rating_game);
            sizeGame = itemView.findViewById(R.id.size_game);
            numberPosition = itemView.findViewById(R.id.number_top_game);
            listenerRef = new WeakReference<>(listener);
            container = itemView.findViewById(R.id.single_game_container);
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listenerRef.get().onPositionClicked(getAdapterPosition(),chipPosition);
                }
            });
        }
    }

    public ArrayList<SingleGameModel> getTopGamesList() {
        return topGamesList;
    }

    public void setTopGamesList(ArrayList<SingleGameModel> topGamesList) {
        this.topGamesList = topGamesList;
    }

    public int getChipPosition() {
        return chipPosition;
    }

    public void setChipPosition(int chipPosition) {
        this.chipPosition = chipPosition;
    }
}
