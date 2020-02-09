package com.example.tabgoplayactivity.utils;

import android.content.Context;
import android.content.res.TypedArray;

import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.model.SectionDataGameModel;
import com.example.tabgoplayactivity.model.SingleMovieModel;

import java.util.ArrayList;

public class DataUtils {

    private static String topMovieTitle[];
    private static String topMovieCategory[];
    private static String topMovieRating[];
    private static String topMoviePrice[];
    private static TypedArray topMoviePhoto;
    private static ArrayList<SingleMovieModel> topMoviesList;

    private static void addMovieToList(){
        topMoviesList = new ArrayList<>();

        for (int i=0;i<topMovieTitle.length;i++){
            SingleMovieModel topMovie = new SingleMovieModel();
            topMovie.setTitle(topMovieTitle[i]);
            topMovie.setCategory(topMovieCategory[i]);
            topMovie.setRating(topMovieRating[i]);
            topMovie.setPrice(topMoviePrice[i]);
//            topMovie.setImage(topMoviePhoto.getResourceId(i,-1));
            topMoviesList.add(topMovie);
        }
    }

    public static ArrayList<SingleMovieModel> getDataMovie(Context context){
        topMovieTitle = context.getResources().getStringArray(R.array.top_movies_name);
        topMovieCategory = context.getResources().getStringArray(R.array.top_movies_category);
        topMovieRating = context.getResources().getStringArray(R.array.top_movies_rating);
        topMoviePrice = context.getResources().getStringArray(R.array.top_movies_price);
        topMoviePhoto = context.getResources().obtainTypedArray(R.array.top_movies_photo);
        addMovieToList();
        return topMoviesList;
    }
}
