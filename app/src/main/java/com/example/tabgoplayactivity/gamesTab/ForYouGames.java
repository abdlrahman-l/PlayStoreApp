package com.example.tabgoplayactivity.gamesTab;


import android.content.Intent;
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
import com.example.tabgoplayactivity.SectionDetailsActivity;
import com.example.tabgoplayactivity.adapter.RecyclerViewPerSectionAdapter;
import com.example.tabgoplayactivity.listener.ClickListener;
import com.example.tabgoplayactivity.model.SectionDataGameModel;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.example.tabgoplayactivity.utils.CommonUtils;
import com.example.tabgoplayactivity.utils.DataUtils;
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
        RecyclerViewPerSectionAdapter adapter = new RecyclerViewPerSectionAdapter(allSampleGameData, getActivity(), FOR_YOU_GAMES, MainActivity.GAME_CAROUSEL, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                CommonUtils.goToSectionDetail(getActivity(),position,allSampleGameData);
            }

            @Override
            public void onPositionClicked(int position, int position2) {

            }
        });
        adapter.setFm(getChildFragmentManager());
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
            DataUtils dataUtils = new DataUtils();
            ArrayList<SingleGameModel> singleItem = dataUtils.getListGames(getActivity());

            dm.setAllItemsInSection(singleItem);

            allSampleGameData.add(dm);

        }
    }
}
