package com.example.tabgoplayactivity;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabgoplayactivity.adapter.TabGameCategoryAdapter;
import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

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
        movieViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(movieTabLayout));
    }

    private void setUpViewPager(ViewPager viewPager){
        TabGameCategoryAdapter categoryAdapter = new TabGameCategoryAdapter(getChildFragmentManager());
        categoryAdapter.addFragment(new ForYouFragment());
        categoryAdapter.addFragment(new TopFragment());
        viewPager.setAdapter(categoryAdapter);
    }
}
