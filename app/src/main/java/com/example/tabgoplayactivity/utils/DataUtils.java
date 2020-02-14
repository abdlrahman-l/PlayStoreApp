package com.example.tabgoplayactivity.utils;

import android.content.Context;
import android.content.res.TypedArray;

import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.model.ChoiceModel;
import com.example.tabgoplayactivity.model.SectionChoiceModel;
import com.example.tabgoplayactivity.model.SectionDataGameModel;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.example.tabgoplayactivity.model.SingleMovieModel;

import java.util.ArrayList;

public class DataUtils {

    private static String topMovieTitle[];
    private static String topMovieCategory[];
    private static String topMovieRating[];
    private static String topMoviePrice[];
    private static TypedArray topMoviePhoto;
    private static ArrayList<SingleMovieModel> topMoviesList;
    private static ArrayList<ArrayList<SingleGameModel>> listGames = new ArrayList<>();
    private static ArrayList<ArrayList<ChoiceModel>> listChoice = new ArrayList<>();
    private static ArrayList<ArrayList<SectionChoiceModel>> listSectionChoice = new ArrayList<>();

    private static void addListSectionChoice(){
        for (int i =0; i<5; i++){
            ArrayList<SectionChoiceModel> sectionChoice = new ArrayList<>();
            sectionChoice.add(new SectionChoiceModel("header "+i,listChoice.get(i)));
            listSectionChoice.add(sectionChoice);
        }
    }

    private static void addListChoices(){
        for (int i = 0; i < 5; i++){
            ArrayList<ChoiceModel> choice = new ArrayList<>();
            choice.add(new ChoiceModel(0,"header description "+i,listGames.get(i)));
            listChoice.add(choice);
        }
    }

    private static void addListGames(){
        for (int j = 0; j <= 5; j++) {
            ArrayList<SingleGameModel> singleItem = new ArrayList<>();
            singleItem.add(new SingleGameModel("Item " + j,j+" MB", "URL " + j));
            listGames.add(singleItem);
        }
    }

    public static ArrayList<ArrayList<SectionChoiceModel>> getDataChoice(){
        addListGames();
        addListChoices();
        addListSectionChoice();

        return listSectionChoice;
    }

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

    public static void addSectionChoiceData(){

    }
}
