package com.example.tabgoplayactivity.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.ortiz.touchview.TouchImageView;

import java.util.ArrayList;

import static android.widget.LinearLayout.*;

public class TouchImageAdapter extends PagerAdapter {


    private ArrayList<Integer> idDrawableList;

    public TouchImageAdapter(ArrayList<Integer> idDrawableList) {
        this.idDrawableList = idDrawableList;
    }

    @NonNull
    @Override
    public View instantiateItem(@NonNull ViewGroup container, int position) {
        TouchImageView touchImageView = new TouchImageView(container.getContext());
        touchImageView.setImageResource(idDrawableList.get(position));
        container.addView(touchImageView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
       return touchImageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return null != idDrawableList ? idDrawableList.size() : 0 ;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
