package com.example.tabgoplayactivity.gamesTab;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.adapter.EditorChoiceRvAdapter;
import com.example.tabgoplayactivity.model.ChoiceModel;
import com.example.tabgoplayactivity.model.SectionChoiceModel;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.example.tabgoplayactivity.utils.DataUtils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditorChoiceGamesFragment extends Fragment {

    private RecyclerView editorChoiceRv;
    public EditorChoiceGamesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_editor_choice_games, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editorChoiceRv = view.findViewById(R.id.rv_editor_choice);
        editorChoiceRv.setHasFixedSize(true);
        editorChoiceRv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));

        EditorChoiceRvAdapter adapter = new EditorChoiceRvAdapter(getActivity(), DataUtils.getDataChoice());
        editorChoiceRv.setAdapter(adapter);

    }
}
