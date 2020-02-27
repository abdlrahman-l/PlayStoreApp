package com.example.tabgoplayactivity.utils;

import android.content.Context;
import android.content.Intent;

import com.example.tabgoplayactivity.SectionDetailsActivity;
import com.example.tabgoplayactivity.model.SectionDataGameModel;

import java.util.ArrayList;

public class CommonUtils {

    public static void goToSectionDetail(Context context, int position, ArrayList<SectionDataGameModel> allSampleData){
        Intent detailsSection = new Intent(context, SectionDetailsActivity.class);
        if (allSampleData.get(position).getAllMoviesInSection() != null)
            detailsSection.putExtra(SectionDetailsActivity.MOVIES_SECTION_LIST,allSampleData.get(position).getAllMoviesInSection());
        else if (allSampleData.get(position).getAllItemsInSection() != null)
            detailsSection.putExtra(SectionDetailsActivity.GAMES_SECTION_LIST,allSampleData.get(position).getAllItemsInSection());
        context.startActivity(detailsSection);
    }

}
