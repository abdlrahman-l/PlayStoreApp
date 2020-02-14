package com.example.tabgoplayactivity.model;

import java.io.Serializable;
import java.util.ArrayList;

public class SectionChoiceModel implements Serializable {
    private String headerTitle;
    private ArrayList<ChoiceModel> choiceList;

    public SectionChoiceModel(String headerTitle, ArrayList<ChoiceModel> choiceList) {
        this.headerTitle = headerTitle;
        this.choiceList = choiceList;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<ChoiceModel> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(ArrayList<ChoiceModel> choiceList) {
        this.choiceList = choiceList;
    }
}
