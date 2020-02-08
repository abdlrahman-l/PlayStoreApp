package com.example.tabgoplayactivity;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabgoplayactivity.adapter.RecyclerViewPerSectionAdapter;
import com.example.tabgoplayactivity.adapter.RecyclerViewTopMoviesAdapter;
import com.example.tabgoplayactivity.adapter.SectionListGameAdapter;
import com.example.tabgoplayactivity.adapter.SectionListMovieAdapter;
import com.example.tabgoplayactivity.utils.DataUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class SectionDetaillsFragment extends Fragment {

    RecyclerView recyclerView;

    public SectionDetaillsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_section_detaills, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.section_details_recycler);
        recyclerView.setHasFixedSize(true);
        if (((SectionDetailsActivity)getActivity()).getMovieSectionList() != null) {
            SectionListMovieAdapter adapter = new SectionListMovieAdapter(((SectionDetailsActivity)getActivity()).getMovieSectionList(),getActivity());
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3,RecyclerView.VERTICAL,false));
            recyclerView.setAdapter(adapter);
        }
        else {
            SectionListGameAdapter adapter = new SectionListGameAdapter(((SectionDetailsActivity)getActivity()).getGameSectionList(),getActivity());
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3,RecyclerView.VERTICAL,false));
            recyclerView.setAdapter(adapter);
        }

    }
}
