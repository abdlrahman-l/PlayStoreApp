package com.example.tabgoplayactivity;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabgoplayactivity.adapter.RecyclerViewPerSectionAdapter;
import com.example.tabgoplayactivity.model.SectionDataGameModel;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.example.tabgoplayactivity.model.SingleMovieModel;
import com.example.tabgoplayactivity.utils.DataUtils;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForYouFragment extends Fragment {
    private String topMovieTitle[];
    private String topMovieCategory[];
    private String topMovieRating[];
    private String topMoviePrice[];
    private TypedArray topMoviePhoto;
    private ArrayList<SectionDataGameModel> allSampleData;
    private RecyclerView sectionRecyclerView;
    public final static int FOR_YOU_MOVIES = 123;

    public ForYouFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        createDummyData();
        View view = inflater.inflate(R.layout.fragment_for_you, container, false);
        sectionRecyclerView = view.findViewById(R.id.section_for_movie);
        sectionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        RecyclerViewPerSectionAdapter adapters = new RecyclerViewPerSectionAdapter(allSampleData,getActivity(),FOR_YOU_MOVIES);
        adapters.setFm(getChildFragmentManager());
        adapters.notifyDataSetChanged();
        sectionRecyclerView.setAdapter(adapters);
        sectionRecyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void createDummyData() {
        allSampleData = new ArrayList<>();
        SectionDataGameModel dm = new SectionDataGameModel();
        dm.setHeaderTitle("Film yang baru tiba");
        dm.setDescriptionTitle("Nikmati koleksi film terbaru kami");
        dm.setAllMoviesInSection(DataUtils.getDataMovie(getActivity()));
        allSampleData.add(dm);

        SectionDataGameModel dm2 = new SectionDataGameModel();
        dm2.setHeaderTitle("Film terpopuler");
        dm2.setDescriptionTitle("");
        dm2.setAllMoviesInSection(DataUtils.getDataMovie(getActivity()));

        allSampleData.add(dm2);
    }



}
