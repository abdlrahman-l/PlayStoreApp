package com.example.tabgoplayactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabgoplayactivity.MainActivity;
import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.example.tabgoplayactivity.model.SingleMovieModel;

import java.util.ArrayList;

public class SectionListCarouselAdapter extends RecyclerView.Adapter<SectionListCarouselAdapter.ViewHolder> {

    private ArrayList<SingleGameModel> listGame;
    private int whichTab;
    private Context mContext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_carousel,null);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    public SectionListCarouselAdapter(Context mContext, int whichTab) {
        this.mContext = mContext;
        this.whichTab = whichTab;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        switch (whichTab){
            case MainActivity.APP_CAROUSEL:

                break;
            case MainActivity.GAME_CAROUSEL:
                    SingleGameModel singleGameModel = listGame.get(position);
                    holder.nameApp.setText(singleGameModel.getGameName());
                    holder.rateApp.setText(String.valueOf(singleGameModel.getGameRating()));
//                    holder.imageIcon.setImageResource(singleGameModel.getGameIcon());
                break;
        }
    }

    @Override
    public int getItemCount() {
        switch (whichTab){
            case MainActivity
                    .APP_CAROUSEL:
            case MainActivity.GAME_CAROUSEL:
               return (null != listGame ? listGame.size() : 0);
            default:
                return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageCarousel;
        protected ImageView imageIcon;
        protected TextView nameApp,rateApp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageCarousel = itemView.findViewById(R.id.image_carousel);
            imageIcon = itemView.findViewById(R.id.image_icon);
            nameApp = itemView.findViewById(R.id.name);
            rateApp = itemView.findViewById(R.id.rating);

        }
    }

    public ArrayList<SingleGameModel> getListGame() {
        return listGame;
    }

    public void setListGame(ArrayList<SingleGameModel> listGame) {
        this.listGame = listGame;
    }

}
