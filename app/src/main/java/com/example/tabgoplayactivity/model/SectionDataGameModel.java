package com.example.tabgoplayactivity.model;

import java.io.Serializable;
import java.util.ArrayList;

public class SectionDataGameModel implements Serializable {
    private String headerTitle;
    private String descriptionTitle;

    private ArrayList<SingleGameModel> allItemsInSection;
    private ArrayList<SingleMovieModel> allMoviesInSection;

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
    public ArrayList<SingleMovieModel> getAllMoviesInSection() {
        return allMoviesInSection;
    }

    public void setAllMoviesInSection(ArrayList<SingleMovieModel> allMoviesInSection) {
        this.allMoviesInSection = allMoviesInSection;
    }

}
