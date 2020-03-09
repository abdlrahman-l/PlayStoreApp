package com.example.tabgoplayactivity;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabgoplayactivity.adapter.RecyclerViewTopMoviesAdapter;
import com.example.tabgoplayactivity.model.SingleMovieModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {

    private String topMovieTitle[];
    private String topMovieCategory[];
    private String topMovieRating[];
    private String topMoviePrice[];
    private TypedArray topMoviePhoto;
    private ArrayList<SingleMovieModel> topMoviesList;

    RecyclerView topMovieRecycler;

    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        topMovieRecycler = view.findViewById(R.id.top_movies_recycler);
        prepareResource();
        addItemToList();
        topMovieRecycler.setHasFixedSize(true);
        RecyclerViewTopMoviesAdapter moviesAdapter = new RecyclerViewTopMoviesAdapter(topMoviesList,getActivity());
        topMovieRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        topMovieRecycler.setAdapter(moviesAdapter);
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
