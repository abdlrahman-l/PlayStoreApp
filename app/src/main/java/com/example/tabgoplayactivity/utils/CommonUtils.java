package com.example.tabgoplayactivity.utils;

import android.content.Context;
import android.content.Intent;

import com.example.tabgoplayactivity.DetailsActivity;
import com.example.tabgoplayactivity.PhotoDetailsActivity;
import com.example.tabgoplayactivity.SectionDetailsActivity;
import com.example.tabgoplayactivity.model.SectionDataGameModel;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.example.tabgoplayactivity.model.SingleMovieModel;

import java.util.ArrayList;

public class CommonUtils {

    public static void goToSectionDetail(Context context, int position, ArrayList<SectionDataGameModel> allSampleData){
        Intent detailsSection = new Intent(context, SectionDetailsActivity.class);
        if (allSampleData.get(position).getAllMoviesInSection() != null)
            detailsSection.putExtra(SectionDetailsActivity.MOVIES_SECTION_LIST,allSampleData.get(position).getAllMoviesInSection());
        else if (allSampleData.get(position).getAllItemsInSection() != null)
            detailsSection.putExtra(SectionDetailsActivity.GAMES_SECTION_LIST,allSampleData.get(position).getAllItemsInSection());
        context.startActivity(detailsSection);
    }

    public static void goToGameDetail(Context context, SingleGameModel singleGame){
        Intent detailIntent = new Intent(context, DetailsActivity.class);
        detailIntent.putExtra(DetailsActivity.GAME_DETAILS,singleGame);
        context.startActivity(detailIntent);
    }

    public static void goToPhotosDetails(Context context, ArrayList<Integer> idDrawableList,int position){
        Intent detailIntent = new Intent(context, PhotoDetailsActivity.class);
        detailIntent.putExtra(PhotoDetailsActivity.LIST_PHOTO_DETAILS,idDrawableList);
        detailIntent.putExtra(PhotoDetailsActivity.PHOTO_POSITIONS,position);
        context.startActivity(detailIntent);
    }

    public static void goToMovieDetail(Context context, SingleMovieModel singleMovie){
        Intent detailIntent = new Intent(context, DetailsActivity.class);
        detailIntent.putExtra(DetailsActivity.MOVIE_DETAILS,singleMovie);
        context.startActivity(detailIntent);
    }

}
