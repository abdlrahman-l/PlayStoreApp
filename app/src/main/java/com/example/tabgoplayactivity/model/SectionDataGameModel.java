package com.example.tabgoplayactivity.model;

import java.util.ArrayList;

public class SectionDataGameModel {
    private String headerTitle;
    private ArrayList<SingleGameModel> allItemsInSection;

    public SectionDataGameModel(){

    }

    public SectionDataGameModel(String headerTitle, ArrayList<SingleGameModel> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
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
}
