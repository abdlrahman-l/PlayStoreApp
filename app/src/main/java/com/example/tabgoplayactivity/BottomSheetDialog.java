package com.example.tabgoplayactivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tabgoplayactivity.model.SingleGameModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    private TextView name;
    private TextView rating;
    private SingleGameModel singleGame;

    public BottomSheetDialog(SingleGameModel singleGame) {
        this.singleGame = singleGame;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_dialog,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name = view.findViewById(R.id.name);
        rating = view.findViewById(R.id.rating);
        name.setText(singleGame.getGameName());
        rating.setText(String.valueOf(singleGame.getGameRating()));
    }
}
