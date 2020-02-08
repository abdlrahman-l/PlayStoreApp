package com.example.tabgoplayactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.lapism.searchview.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    SearchView searchView;
    RelativeLayout rlSearch;

    TabGoplayAdapter tabGooglePlayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        searchView = findViewById(R.id.searchView);
        rlSearch = findViewById(R.id.rlSearch);

        setupTabLayout();
    }

    public void setStatusBarColor(String color){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            int statusBarColor = Color.parseColor(color);
            if (statusBarColor == Color.BLACK && window.getNavigationBarColor() == Color.BLACK){
                window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            }else{
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            }
            window.setStatusBarColor(statusBarColor);
        }
    }
    private void setupTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.app_selected));
        tabLayout.getTabAt(0).setText("Apps");
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.joystick));
        tabLayout.getTabAt(1).setText("Games");
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.cinema));
        tabLayout.getTabAt(2).setText("Movies");
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.book));
        tabLayout.getTabAt(3).setText("Books");
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabGooglePlayAdapter =new TabGoplayAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(tabGooglePlayAdapter);
        tabLayout.setSelectedTabIndicatorHeight(0);
//        setStatusBarColor("#3F51B5");
//        tabLayout.setBackgroundColor(Color.parseColor("#3F51B5"));
//        rlSearch.setBackgroundColor(Color.parseColor("#3F51B5"));a
        searchView.setHint("Search Home");
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
//                        setStatusBarColor("#3F51B5");
//                        tabLayout.setBackgroundColor(Color.parseColor("#3F51B5"));
//                        rlSearch.setBackgroundColor(Color.parseColor("#3F51B5"));
                        tabLayout.getTabAt(0).setIcon(R.drawable.app_selected);
                        tabLayout.getTabAt(1).setIcon(R.drawable.joystick);
                        tabLayout.getTabAt(2).setIcon(R.drawable.cinema);
                        tabLayout.getTabAt(3).setIcon(R.drawable.book);
                        searchView.setHint("Search Home");
                        break;
                    case 1:
//                        setStatusBarColor("#007a0e");
//                        tabLayout.setBackgroundColor(Color.parseColor("#007a0e"));
//                        rlSearch.setBackgroundColor(Color.parseColor("#007a0e"));
                        tabLayout.getTabAt(1).setIcon(R.drawable.joystick_selected);
                        tabLayout.getTabAt(0).setIcon(R.drawable.app);
                        tabLayout.getTabAt(2).setIcon(R.drawable.cinema);
                        tabLayout.getTabAt(3).setIcon(R.drawable.book);
                        searchView.setHint("Search Games");
                        break;
                    case 2:
//                        setStatusBarColor("#960000");
//                        tabLayout.setBackgroundColor(Color.parseColor("#960000"));
//                        rlSearch.setBackgroundColor(Color.parseColor("#960000"));
                        tabLayout.getTabAt(2).setIcon(R.drawable.cinema_selected);
                        tabLayout.getTabAt(0).setIcon(R.drawable.app);
                        tabLayout.getTabAt(1).setIcon(R.drawable.joystick);
                        tabLayout.getTabAt(3).setIcon(R.drawable.book);
                        searchView.setHint("Search Movies");
                        break;
                    case 3:
//                        setStatusBarColor("#008282");
//                        tabLayout.setBackgroundColor(Color.parseColor("#008282"));
//                        rlSearch.setBackgroundColor(Color.parseColor("#008282"));
                        tabLayout.getTabAt(0).setIcon(R.drawable.app);
                        tabLayout.getTabAt(1).setIcon(R.drawable.joystick);
                        tabLayout.getTabAt(2).setIcon(R.drawable.cinema);
                        tabLayout.getTabAt(3).setIcon(R.drawable.book_selected);
                        searchView.setHint("Search Books");
                        break;
                }
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public SearchView getSearchView() {
        return searchView;
    }

}
