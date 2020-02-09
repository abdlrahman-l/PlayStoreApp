package com.example.tabgoplayactivity.model;

import java.io.Serializable;

public class SingleGameModel implements Serializable {

    private String gameName;
    private int gameRating;
    private String gameDescription;
    private String gameSize;
    private int gameIcon;

    public SingleGameModel(){

    }

    public SingleGameModel(String gameName, String gameSize, String gameDescription) {
        this.gameName = gameName;
        this.gameSize = gameSize;
        this.gameDescription = gameDescription;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getGameRating() {
        return gameRating;
    }

    public void setGameRating(int gameRating) {
        this.gameRating = gameRating;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }
    public String getGameSize() {
        return gameSize;
    }

    public void setGameSize(String gameSize) {
        this.gameSize = gameSize;
    }

    public int getGameIcon() {
        return gameIcon;
    }

    public void setGameIcon(int gameIcon) {
        this.gameIcon = gameIcon;
    }

}
