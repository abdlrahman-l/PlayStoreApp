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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopGamesFragment extends Fragment {

    private RecyclerView topGamesCategoryRv;
    private ArrayList<String> topCategoryNames;

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
        topGamesCategoryRv = view.findViewById(R.id.top_category_games);
        CategoryTopRecyclerView adapter = new CategoryTopRecyclerView(topCategoryNames,getActivity());
        topGamesCategoryRv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        topGamesCategoryRv.setHasFixedSize(true);
        topGamesCategoryRv.setAdapter(adapter);
    }

    public void declareTopCategoryNames(){
        topCategoryNames = new ArrayList<>();
        topCategoryNames.add("Top Free");
        topCategoryNames.add("Top Grossing");
        topCategoryNames.add("Trending");
        topCategoryNames.add("Top paid");
    }
}
