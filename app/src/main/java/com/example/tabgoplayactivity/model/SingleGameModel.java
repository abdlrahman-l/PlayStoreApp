package com.example.tabgoplayactivity.model;

public class SingleGameModel {

    private String gameName;
    private int gameRating;
    private String gameDescription;

    public SingleGameModel(){

    }

    public SingleGameModel(String gameName, int gameRating, String gameDescription) {
        this.gameName = gameName;
        this.gameRating = gameRating;
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
}
