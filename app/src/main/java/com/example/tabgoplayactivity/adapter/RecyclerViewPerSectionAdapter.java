package com.example.tabgoplayactivity.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tabgoplayactivity.ForYouFragment;
import com.example.tabgoplayactivity.GamesFragment;
import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.model.SectionDataGameModel;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.example.tabgoplayactivity.model.SingleMovieModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewPerSectionAdapter extends RecyclerView.Adapter<RecyclerViewPerSectionAdapter.ItemRowHolder> {

    private ArrayList<SectionDataGameModel> dataList;
    private Context mContext;
    private int whichFragment;

    public RecyclerViewPerSectionAdapter(ArrayList<SectionDataGameModel> dataList, Context mContext, int whichFragment) {
        this.dataList = dataList;
        this.mContext = mContext;
        this.whichFragment = whichFragment;
    }

    @NonNull
    @Override
    public ItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_game,null);
        ItemRowHolder itemRowHolder = new ItemRowHolder(v);
        return itemRowHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRowHolder holder, int position) {
        final String sectionName = dataList.get(position).getHeaderTitle();
        holder.sectionTitle.setText(dataList.get(position).getHeaderTitle());
        if (dataList.get(position).getDescriptionTitle().equals("")){
            holder.descriptionTitle.setVisibility(View.GONE);
        }else{
            holder.descriptionTitle.setText(dataList.get(position).getDescriptionTitle());
        }
        switch (whichFragment){
            case ForYouFragment.FOR_YOU_MOVIES:
                ArrayList<SingleMovieModel> singleSectionMovies = dataList.get(position).getAllMoviesInSection();
                SectionListMovieAdapter sectionListMoviesAdapter = new SectionListMovieAdapter(singleSectionMovies,mContext);
                holder.sectionRecyclerView.setAdapter(sectionListMoviesAdapter);
                break;
            case GamesFragment.FOR_YOU_GAMES:
                ArrayList<SingleGameModel> singleSectionGames = dataList.get(position).getAllItemsInSection();
                SectionListGameAdapter sectionListAdapter = new SectionListGameAdapter(singleSectionGames,mContext);
                holder.sectionRecyclerView.setAdapter(sectionListAdapter);
                break;
        }
        holder.sectionRecyclerView.setHasFixedSize(true);
        holder.sectionRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));

        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"test "+sectionName,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView sectionTitle;
        protected TextView descriptionTitle;
        protected RecyclerView sectionRecyclerView;
        protected ImageView btnMore;

        public ItemRowHolder(@NonNull View itemView) {
            super(itemView);
            this.sectionTitle = itemView.findViewById(R.id.item_title);
            this.btnMore = itemView.findViewById(R.id.btn_next);
            this.descriptionTitle = itemView.findViewById(R.id.item_title_description);
            this.sectionRecyclerView = itemView.findViewById(R.id.game_recycler_view);
        }
    }
}
