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

import com.example.tabgoplayactivity.MainActivity;
import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.adapter.RecyclerViewPerSectionAdapter;
import com.example.tabgoplayactivity.model.SectionDataGameModel;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.lapism.searchview.widget.SearchView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForYouGames extends Fragment {


    public final static int FOR_YOU_GAMES = 681;
    private ArrayList<SectionDataGameModel> allSampleGameData;
    private SearchView searchView;

    public ForYouGames() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_for_you_games, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createDummyData();
        RecyclerView sectionRecyclerView = view.findViewById(R.id.section_recycler_view);
        sectionRecyclerView.setHasFixedSize(true);
        RecyclerViewPerSectionAdapter adapter = new RecyclerViewPerSectionAdapter(allSampleGameData,getActivity(),FOR_YOU_GAMES, MainActivity.GAME_CAROUSEL);
        adapter.notifyDataSetChanged();
        sectionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        sectionRecyclerView.setAdapter(adapter);
    }



    public void createDummyData() {
        allSampleGameData = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {

            SectionDataGameModel dm = new SectionDataGameModel();

            dm.setHeaderTitle("Section " + i);
            dm.setDescriptionTitle("Description" + i);
            ArrayList<SingleGameModel> singleItem = new ArrayList<SingleGameModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleGameModel("Item " + j,j+" MB", "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleGameData.add(dm);

        }
    }
}
