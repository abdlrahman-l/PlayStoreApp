package com.example.tabgoplayactivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tabgoplayactivity.model.SingleGameModel;
import com.example.tabgoplayactivity.model.SingleMovieModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    private TextView name,nameMovie;
    private TextView rating,categoryMovie;
    private Button buySd,btnInstall;
    private LinearLayout btnMovieContainer;
    private RelativeLayout movieContainer;
    private RelativeLayout imageGameLayout;
    private ImageView imageMovie;
    private SingleGameModel singleGame;
    private SingleMovieModel singleMovie;
    private ImageView imageIcon;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_dialog,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setView(view);
    }

    public void setView(View view){
        if (singleGame != null){
            name = view.findViewById(R.id.name);
            rating = view.findViewById(R.id.rating);
            imageIcon = view.findViewById(R.id.image_icon);
            imageIcon.setImageResource(singleGame.getGameIcon());
            name.setText(singleGame.getGameName());
            rating.setText(String.valueOf(singleGame.getGameRating()));
        }else if (singleMovie != null){
            buySd = view.findViewById(R.id.buy_sd);
            btnMovieContainer = view.findViewById(R.id.btn_movie_layout);
            movieContainer = view.findViewById(R.id.image_movie_layout);
            imageMovie = view.findViewById(R.id.image_film);
            btnInstall = view.findViewById(R.id.btn_install);
            imageGameLayout = view.findViewById(R.id.image_game_layout);
            nameMovie = view.findViewById(R.id.name_movie);
            categoryMovie = view.findViewById(R.id.category_movie);
            btnInstall.setVisibility(View.GONE);
            imageGameLayout.setVisibility(View.GONE);
            btnMovieContainer.setVisibility(View.VISIBLE);
            movieContainer.setVisibility(View.VISIBLE);
            String harga = String.format(getResources().getString(R.string.buy_sd),getSingleMovie().getPrice());
            buySd.setText(harga);
            nameMovie.setText(getSingleMovie().getTitle());
            categoryMovie.setText(getSingleMovie().getCategory());
            imageMovie.setImageResource(getSingleMovie().getImage());
        }
    }

    public SingleGameModel getSingleGame() {
        return singleGame;
    }

    public void setSingleGame(SingleGameModel singleGame) {
        this.singleGame = singleGame;
    }

    public SingleMovieModel getSingleMovie() {
        return singleMovie;
    }

    public void setSingleMovie(SingleMovieModel singleMovie) {
        this.singleMovie = singleMovie;
    }
}
