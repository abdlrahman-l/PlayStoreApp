package com.example.tabgoplayactivity.gamesTab;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabgoplayactivity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditorChoiceGamesFragment extends Fragment {


    public EditorChoiceGamesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_editor_choice_games, container, false);
    }

}
