package com.example.tabgoplayactivity;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.tabgoplayactivity.adapter.RecyclerViewPerSectionAdapter;
import com.example.tabgoplayactivity.adapter.TabGameCategoryAdapter;
import com.example.tabgoplayactivity.gamesTab.ForYouGames;
import com.example.tabgoplayactivity.gamesTab.TopGamesFragment;
import com.example.tabgoplayactivity.model.SectionDataGameModel;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.google.android.material.tabs.TabLayout;
import com.lapism.searchview.widget.SearchView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GamesFragment extends Fragment {
    private SearchView searchView;
    private TabLayout movieTabLayout;
    private ViewPager movieViewPager;

    public GamesFragment() {
        // Required empty public constructor
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

    private void setUpViewPager(ViewPager viewPager){
        TabGameCategoryAdapter categoryAdapter = new TabGameCategoryAdapter(getChildFragmentManager());
        categoryAdapter.addFragment(new ForYouGames());
        categoryAdapter.addFragment(new TopGamesFragment());
        viewPager.setAdapter(categoryAdapter);
    }


}
