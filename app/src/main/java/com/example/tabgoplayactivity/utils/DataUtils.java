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
    private static ArrayList<SectionChoiceModel> listSectionChoice = new ArrayList<>();
    private static TypedArray nestedArrayGameCarousel;
    private static TypedArray gameCarousel;

    private static void addListSectionChoice(){
        for (int i =0; i<5; i++){
            ArrayList<SectionChoiceModel> sectionChoice = new ArrayList<>();
            listSectionChoice.add(new SectionChoiceModel("header "+i,listChoice.get(i)));
        }
    }

    private static void addListChoices(){
        for (int i = 0; i < 5; i++){
            ArrayList<ChoiceModel> choice = new ArrayList<>();
            for (int j = 0; j < 4;j++){
                choice.add(new ChoiceModel(0,"header description "+j,listGames.get(i)));
            }
            listChoice.add(choice);
        }
    }

    private static void addListGames(){
        for (int i = 0; i <= 5; i++) {
            ArrayList<SingleGameModel> singleItem = new ArrayList<>();
            for (int j = 0; j < 4; j++){
                singleItem.add(new SingleGameModel("Item " + j,j+" MB", "URL " + j));
            }
            listGames.add(singleItem);
        }
    }

    private static void addListGames2(ArrayList<SingleGameModel> singleItem, Context context){
        for (int j = 0; j < 4; j++){
            SingleGameModel singleGameModel = new SingleGameModel("Item " + j,j+" MB", "URL " + j);
            singleGameModel.setGameCarousel(getDataGameCarousel(j,context));
            singleItem.add(singleGameModel);
        }
    }

    public static ArrayList<SingleGameModel> getListGames(Context context){
        ArrayList<SingleGameModel> singleGameModels = new ArrayList<>();
        addListGames2(singleGameModels, context);
        return singleGameModels;
    }

    public static ArrayList<ArrayList<ChoiceModel>> getListChoice(){
        addListGames();
        addListChoices();
        return listChoice;
    }

    public static ArrayList<SectionChoiceModel> getDataChoice(){
        if (listSectionChoice.isEmpty()){
            addListGames();
            addListChoices();
            addListSectionChoice();
        }

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
            topMovie.setImage(topMoviePhoto.getResourceId(i,-1));
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

    public static ArrayList<Integer>  getDataGameCarousel(int i,Context context){
        ArrayList<Integer> gameCarouselId = new ArrayList<>();
        nestedArrayGameCarousel = context.getResources().obtainTypedArray(R.array.game_carousel);

        int resId = nestedArrayGameCarousel.getResourceId(i,-1);
        gameCarousel = context.getResources().obtainTypedArray(resId);
        for (int j = 0;j < gameCarousel.length(); j++){
            gameCarouselId.add(gameCarousel.getResourceId(j,-1));
        }

        return gameCarouselId;
    }

    public static void addSectionChoiceData(){

    }
}
