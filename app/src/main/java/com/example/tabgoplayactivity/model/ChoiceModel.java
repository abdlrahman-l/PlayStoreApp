package com.example.tabgoplayactivity.model;

import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

public class ChoiceModel implements Serializable {
    private int imageChoiceId;
    private String headerChoice;
    private ArrayList<SingleGameModel> gameChoiceList;

    public int getImageChoiceId() {
        return imageChoiceId;
    }

    public void setImageChoiceId(int imageChoiceId) {
        this.imageChoiceId = imageChoiceId;
    }

    public String getHeaderChoice() {
        return headerChoice;
    }

    public void setHeaderChoice(String headerChoice) {
        this.headerChoice = headerChoice;
    }

    public ArrayList<SingleGameModel> getGameChoiceList() {
        return gameChoiceList;
    }

    public void setGameChoiceList(ArrayList<SingleGameModel> gameChoiceList) {
        this.gameChoiceList = gameChoiceList;
    }
}
