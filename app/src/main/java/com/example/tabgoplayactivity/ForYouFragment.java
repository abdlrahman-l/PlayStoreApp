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
    private ArrayList<SingleMovieModel> topMoviesList;
    ArrayList<SectionDataGameModel> allSampleData;
    public final static int FOR_YOU_MOVIES = 123;

    public ForYouFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_for_you, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareResource();
        addItemToList();
        createDummyData();
        RecyclerView sectionRecyclerView = view.findViewById(R.id.section_for_movie);
        RecyclerViewPerSectionAdapter adapter = new RecyclerViewPerSectionAdapter(allSampleData,getActivity(),FOR_YOU_MOVIES);
        sectionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        sectionRecyclerView.setAdapter(adapter);
        sectionRecyclerView.setHasFixedSize(true);
    }

    public void createDummyData() {
        allSampleData = new ArrayList<>();
        SectionDataGameModel dm = new SectionDataGameModel();
        dm.setHeaderTitle("Film yang baru tiba");
        dm.setDescriptionTitle("Nikmati koleksi film terbaru kami");
        dm.setAllMoviesInSection(topMoviesList);
        allSampleData.add(dm);

        SectionDataGameModel dm2 = new SectionDataGameModel();
        dm2.setHeaderTitle("Film terpopuler");
        dm2.setDescriptionTitle("");
        dm2.setAllMoviesInSection(topMoviesList);

        allSampleData.add(dm2);
    }

    private void addItemToList(){
        topMoviesList = new ArrayList<>();

        for (int i=0;i<topMovieTitle.length;i++){
            SingleMovieModel topMovie = new SingleMovieModel();
            topMovie.setTitle(topMovieTitle[i]);
            topMovie.setCategory(topMovieCategory[i]);
            topMovie.setRating(topMovieRating[i]);
            topMovie.setPrice(topMoviePrice[i]);
            topMovie.setImage(topMoviePhoto.getResourceId(i,-1));
            topMoviesList.add(topMovie);
        }
    }

    private void prepareResource(){
        topMovieTitle = getResources().getStringArray(R.array.top_movies_name);
        topMovieCategory = getResources().getStringArray(R.array.top_movies_category);
        topMovieRating = getResources().getStringArray(R.array.top_movies_rating);
        topMoviePrice = getResources().getStringArray(R.array.top_movies_price);
        topMoviePhoto = getResources().obtainTypedArray(R.array.top_movies_photo);
    }


}
