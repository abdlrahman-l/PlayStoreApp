package com.example.tabgoplayactivity.model;

import java.util.ArrayList;

public class SectionDataGameModel {
    private String headerTitle;
    private String descriptionTitle;

    private ArrayList<SingleGameModel> allItemsInSection;
    private ArrayList<SingleMovieModel> allMoviesInSection;

    public ArrayList<SingleMovieModel> getAllMoviesInSection() {
        return allMoviesInSection;
    }

    public void setAllMoviesInSection(ArrayList<SingleMovieModel> allMoviesInSection) {
        this.allMoviesInSection = allMoviesInSection;
    }

    public SectionDataGameModel(){

    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleGameModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleGameModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }

    public String getDescriptionTitle() {
        return descriptionTitle;
    }

    public void setDescriptionTitle(String descriptionTitle) {
        this.descriptionTitle = descriptionTitle;
    }
}
