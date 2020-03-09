package com.example.tabgoplayactivity;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tabgoplayactivity.model.SingleMovieModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailsFragment extends Fragment {

    private ImageView imageMovie;
    private TextView nameMovie,categoryMovie;
    private SingleMovieModel singleMovie;

    public MovieDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameMovie = view.findViewById(R.id.name_movie_details);
        categoryMovie = view.findViewById(R.id.category_movie_details);
        imageMovie = view.findViewById(R.id.image_movie_details);
        singleMovie = ((DetailsActivity)getActivity()).getSingleMovie();

        nameMovie.setText(singleMovie.getTitle());
        categoryMovie.setText(singleMovie.getCategory());
        imageMovie.setImageResource(singleMovie.getImage());

    }
}
