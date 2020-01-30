package com.example.tabgoplayactivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabGoplayAdapter extends FragmentStatePagerAdapter {

    private int mNumOfTabs;

    public TabGoplayAdapter(FragmentManager fm, int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new GamesFragment();
            case 2:
                return new MoviesFragment();
            case 3:
                return new BooksFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
