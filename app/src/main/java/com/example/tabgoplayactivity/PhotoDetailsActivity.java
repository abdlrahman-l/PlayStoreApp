package com.example.tabgoplayactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;

import com.example.tabgoplayactivity.adapter.TouchImageAdapter;
import com.example.tabgoplayactivity.model.SingleGameModel;

import java.util.ArrayList;

public class PhotoDetailsActivity extends AppCompatActivity {

    private ViewPager photoDetailsPager;
    public static String LIST_PHOTO_DETAILS="photoDetailsList";
    public static String PHOTO_POSITIONS="photoPositions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);
        photoDetailsPager = findViewById(R.id.photo_details_viewpager);
        photoDetailsPager.setBackgroundColor(Color.BLACK);
        if (getIntent().getSerializableExtra(LIST_PHOTO_DETAILS) != null){
            ArrayList<Integer> idDrawableList = (ArrayList<Integer>) getIntent().getSerializableExtra(LIST_PHOTO_DETAILS);
            int positions = (int) getIntent().getSerializableExtra(PHOTO_POSITIONS);
            TouchImageAdapter touchImageAdapter = new TouchImageAdapter(idDrawableList);
            photoDetailsPager.setAdapter(touchImageAdapter);
            photoDetailsPager.setCurrentItem(positions);
        }
    }

}
