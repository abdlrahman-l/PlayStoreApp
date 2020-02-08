package com.example.tabgoplayactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tabgoplayactivity.model.SectionDataGameModel;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.example.tabgoplayactivity.model.SingleMovieModel;

import java.util.ArrayList;

public class SectionDetailsActivity extends AppCompatActivity {

    public static final String MOVIES_SECTION_LIST = "MoviesSectionKey";
    public static final String GAMES_SECTION_LIST = "GamesSectionKey";
    protected ArrayList<SingleMovieModel> movieSectionList;
    protected ArrayList<SingleGameModel> gameSectionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_details);
        if (getIntent().getSerializableExtra(MOVIES_SECTION_LIST) != null){
            movieSectionList = (ArrayList<SingleMovieModel>) getIntent().getSerializableExtra(MOVIES_SECTION_LIST);
        }
        else{
            gameSectionList = (ArrayList<SingleGameModel>) getIntent().getSerializableExtra(GAMES_SECTION_LIST);
        }
    }

    public ArrayList<SingleMovieModel> getMovieSectionList() {
        return movieSectionList;
    }

    public ArrayList<SingleGameModel> getGameSectionList() {
        return gameSectionList;
    }

}
