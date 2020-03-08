package com.example.tabgoplayactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tabgoplayactivity.ForYouFragment;
import com.example.tabgoplayactivity.MainActivity;
import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.gamesTab.ForYouGames;
import com.example.tabgoplayactivity.listener.ClickListener;
import com.example.tabgoplayactivity.model.SectionDataGameModel;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.example.tabgoplayactivity.model.SingleMovieModel;
import com.example.tabgoplayactivity.utils.CommonUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewPerSectionAdapter extends RecyclerView.Adapter<RecyclerViewPerSectionAdapter.ItemRowHolder> {

    private ArrayList<SectionDataGameModel> dataList;
    private Context mContext;
    private int whichFragment;
    private int appOrGame;
    private FragmentManager fm;
    private final ClickListener listener;

    public RecyclerViewPerSectionAdapter(ArrayList<SectionDataGameModel> dataList, Context mContext, int whichFragment, ClickListener listener) {
        this.dataList = dataList;
        this.mContext = mContext;
        this.whichFragment = whichFragment;
        this.listener = listener;
    }

    public RecyclerViewPerSectionAdapter(ArrayList<SectionDataGameModel> dataList, Context mContext, int whichFragment, int appOrGame, ClickListener listener) {
        this.dataList = dataList;
        this.mContext = mContext;
        this.whichFragment = whichFragment;
        this.appOrGame = appOrGame;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_game,null);
        ItemRowHolder itemRowHolder = new ItemRowHolder(v);
        return itemRowHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRowHolder holder, final int position) {
        final String sectionName = dataList.get(position).getHeaderTitle();
        holder.sectionTitle.setText(dataList.get(position).getHeaderTitle());
        if (dataList.get(position).getDescriptionTitle().equals("")){
            holder.descriptionTitle.setVisibility(View.GONE);
        }else{
            holder.descriptionTitle.setText(dataList.get(position).getDescriptionTitle());
        }
        setAdapter(position,holder);
        holder.sectionRecyclerView.setHasFixedSize(true);
        holder.sectionRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,RecyclerView.HORIZONTAL,false));

        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"test "+sectionName,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter(int position, ItemRowHolder holder){
        if (whichFragment == ForYouFragment.FOR_YOU_MOVIES){
            ArrayList<SingleMovieModel> singleSectionMovies = dataList.get(position).getAllMoviesInSection();
            SectionListMovieAdapter sectionListMoviesAdapter = new SectionListMovieAdapter(singleSectionMovies,mContext,fm);
            sectionListMoviesAdapter.notifyDataSetChanged();
            holder.sectionRecyclerView.setAdapter(sectionListMoviesAdapter);
        }
        else {
            if (position == 0){
                switch (appOrGame){
                    case MainActivity.APP_CAROUSEL:
                        break;
                    case MainActivity.GAME_CAROUSEL:
                        ArrayList<SingleGameModel> singleSectionGames = dataList.get(position).getAllItemsInSection();
                        SectionListCarouselAdapter sectionListAdapter = new SectionListCarouselAdapter(mContext,MainActivity.GAME_CAROUSEL);
                        sectionListAdapter.setListGame(singleSectionGames);
                        sectionListAdapter.notifyDataSetChanged();
                        holder.sectionRecyclerView.setAdapter(sectionListAdapter);
                        break;
                }
            }
            else {
                switch (whichFragment){
                    case ForYouFragment.FOR_YOU_MOVIES:

                        break;
                    case ForYouGames.FOR_YOU_GAMES:
                        final ArrayList<SingleGameModel> singleSectionGames = dataList.get(position).getAllItemsInSection();
                        SectionListGameAdapter sectionListAdapter = new SectionListGameAdapter(singleSectionGames, mContext, fm, new ClickListener() {
                            @Override
                            public void onPositionClicked(int position) {
                                CommonUtils.goToGameDetail(mContext,singleSectionGames.get(position));
                            }

                            @Override
                            public void onPositionClicked(int position, int position2) {

                            }
                        });
                        sectionListAdapter.notifyDataSetChanged();
                        holder.sectionRecyclerView.setAdapter(sectionListAdapter);
                        break;
                }
            }
        }

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
        protected RelativeLayout sectionContainer;
        protected WeakReference<ClickListener> listenerRef;

        public ItemRowHolder(@NonNull View itemView) {
            super(itemView);
            this.listenerRef = new WeakReference<>(listener);
            this.sectionTitle = itemView.findViewById(R.id.item_title);
            this.btnMore = itemView.findViewById(R.id.btn_next);
            this.descriptionTitle = itemView.findViewById(R.id.item_title_description);
            this.sectionRecyclerView = itemView.findViewById(R.id.game_recycler_view);
            this.sectionContainer = itemView.findViewById(R.id.section_container);
            this.sectionContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listenerRef.get().onPositionClicked(getAdapterPosition());
                }
            });
        }
    }

    public FragmentManager getFm() {
        return fm;
    }

    public void setFm(FragmentManager fm) {
        this.fm = fm;
    }

}
