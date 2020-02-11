package com.example.tabgoplayactivity.gamesTab;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.adapter.CategoryTopRecyclerView;
import com.example.tabgoplayactivity.adapter.RecyclerViewTopGamesAdapter;
import com.example.tabgoplayactivity.listener.ClickListener;
import com.example.tabgoplayactivity.model.SingleGameModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopGamesFragment extends Fragment {

    private RecyclerView topGamesCategoryRv;
    private RecyclerView topListGamesCategoryRv;
    private ArrayList<String> topCategoryNames;
    private ArrayList<ArrayList<SingleGameModel>> arrayListsAllGames;
    private ArrayList<SingleGameModel> singleItem;
    private ArrayList<SingleGameModel> singleItem2;
    public TopGamesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_games, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        declareTopCategoryNames();
        setListTopCategory(view);
        setTopCategoryTab(view);
    }

    public void declareTopCategoryNames(){
        topCategoryNames = new ArrayList<>();
        topCategoryNames.add("Top Free");
        topCategoryNames.add("Top Grossing");
        topCategoryNames.add("Trending");
        topCategoryNames.add("Top paid");
    }

    public void setTopCategoryTab(View view){
        arrayListsAllGames = new ArrayList<>();
        singleItem = new ArrayList<SingleGameModel>();
        singleItem2 = new ArrayList<SingleGameModel>();
        for (int j = 0; j <= 5; j++) {
            singleItem.add(new SingleGameModel("Item " + j,j+" MB", "URL " + j));
        }
        for (int j = 6; j <= 11; j++) {
            singleItem2.add(new SingleGameModel("Item " + j,j+" MB", "URL " + j));
        }
        arrayListsAllGames.add(singleItem);
        arrayListsAllGames.add(singleItem2);
        topListGamesCategoryRv = view.findViewById(R.id.top_category_games_list);
        final RecyclerViewTopGamesAdapter adapters = new RecyclerViewTopGamesAdapter(getActivity(), singleItem);
        topListGamesCategoryRv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        topListGamesCategoryRv.setHasFixedSize(true);
        topListGamesCategoryRv.setAdapter(adapters);

        topGamesCategoryRv = view.findViewById(R.id.top_category_games);
        final CategoryTopRecyclerView adapter = new CategoryTopRecyclerView(topCategoryNames, getActivity(), new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                    adapters.setTopGamesList(arrayListsAllGames.get(position));
                    adapters.notifyDataSetChanged();
            }
        });
        topGamesCategoryRv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        topGamesCategoryRv.setHasFixedSize(true);
        topGamesCategoryRv.setAdapter(adapter);
    }
    public void setListTopCategory(View view){

    }
}
