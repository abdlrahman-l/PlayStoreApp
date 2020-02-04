package com.example.tabgoplayactivity;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabgoplayactivity.adapter.TabGameCategoryAdapter;
import com.example.tabgoplayactivity.model.SingleMovieModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private String topMovieTitle[];
    private String topMovieCategory[];
    private String topMovieRating[];
    private String topMoviePrice[];
    private TypedArray topMoviePhoto;
    private ArrayList<SingleMovieModel> topMoviesList;

    TabLayout movieTabLayout;
    ViewPager movieViewPager;

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        movieTabLayout = view.findViewById(R.id.tab_layout_movie);
        movieViewPager = view.findViewById(R.id.view_pager_movie);
        movieTabLayout.setupWithViewPager(movieViewPager);

        setUpViewPager(movieViewPager);

        movieTabLayout.getTabAt(0).setText("For you");
        movieTabLayout.getTabAt(1).setText("Top");
        movieTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        movieTabLayout.setTabIndicatorFullWidth(false);
        movieViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(movieTabLayout));
    }

    private void setUpViewPager(ViewPager viewPager){
        TabGameCategoryAdapter categoryAdapter = new TabGameCategoryAdapter(getChildFragmentManager());
        categoryAdapter.addFragment(new ForYouFragment());
        categoryAdapter.addFragment(new TopFragment());
        viewPager.setAdapter(categoryAdapter);
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
