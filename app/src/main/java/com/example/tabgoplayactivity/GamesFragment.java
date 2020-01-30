package com.example.tabgoplayactivity;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.tabgoplayactivity.adapter.RecyclerViewPerSectionAdapter;
import com.example.tabgoplayactivity.model.SectionDataGameModel;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.lapism.searchview.widget.SearchView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GamesFragment extends Fragment {

    ArrayList<SectionDataGameModel> allSampleGameData;
    private SearchView searchView;
    public GamesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createDummyData();
        RecyclerView sectionRecyclerView = view.findViewById(R.id.section_recycler_view);
        sectionRecyclerView.setHasFixedSize(true);
        RecyclerViewPerSectionAdapter adapter = new RecyclerViewPerSectionAdapter(allSampleGameData,getActivity());
        sectionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        sectionRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        searchView = ((MainActivity)this.getActivity()).getSearchView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games, container, false);
    }


    public void createDummyData() {
        allSampleGameData = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {

            SectionDataGameModel dm = new SectionDataGameModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<SingleGameModel> singleItem = new ArrayList<SingleGameModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleGameModel("Item " + j,j, "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleGameData.add(dm);

        }
    }

}
