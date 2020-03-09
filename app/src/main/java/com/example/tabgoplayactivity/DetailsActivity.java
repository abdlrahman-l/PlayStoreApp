package com.example.tabgoplayactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.widget.TextView;

import com.example.tabgoplayactivity.model.SingleGameModel;
import com.example.tabgoplayactivity.model.SingleMovieModel;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    public static final String GAME_DETAILS = "GameDetailsKey";
    public static final String MOVIE_DETAILS = "MovieDetailsKey";
    protected SingleGameModel singleGame;
    protected SingleMovieModel singleMovie;
    private NavHostFragment navHostFragment;
    private NavInflater navInflater;
    private NavGraph navGraph;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_detail);
        navController = navHostFragment.getNavController();
        navInflater = navController.getNavInflater();
        navGraph = navInflater.inflate(R.navigation.nav_graph_activity);
        if (getIntent().getSerializableExtra(GAME_DETAILS) != null){
            singleGame = (SingleGameModel) getIntent().getSerializableExtra(GAME_DETAILS);
            navGraph.setStartDestination(R.id.detail_fragment);
        } else if (getIntent().getSerializableExtra(MOVIE_DETAILS) != null){
            singleMovie = (SingleMovieModel) getIntent().getSerializableExtra(MOVIE_DETAILS);
            navGraph.setStartDestination(R.id.movie_detail_fragment);
        }
        navController.setGraph(navGraph);
    }

    public SingleGameModel getSingleGame() {
        return singleGame;
    }

    public SingleMovieModel getSingleMovie() {
        return singleMovie;
    }
}
