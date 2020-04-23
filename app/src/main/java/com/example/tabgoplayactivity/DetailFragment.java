package com.example.tabgoplayactivity;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tabgoplayactivity.adapter.CarouselAdapter;
import com.example.tabgoplayactivity.model.SingleGameModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private SingleGameModel singleGame;
    private TextView detailName,detailName2;
    private ImageView iconDetail;
    private RecyclerView carouselRecycler;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        detailName = view.findViewById(R.id.name_detail);
        detailName2 = view.findViewById(R.id.name_detail_2);
        iconDetail = view.findViewById(R.id.icon_detail);
        carouselRecycler = view.findViewById(R.id.carousel_recycler);
        carouselRecycler.setHasFixedSize(true);
        singleGame = ((DetailsActivity)getActivity()).getSingleGame();
        detailName.setText(singleGame.getGameName());
        detailName2.setText(singleGame.getGameName());
        iconDetail.setImageResource(singleGame.getGameIcon());
        if (singleGame.getGameCarousel() != null){
            CarouselAdapter carouselAdapter = new CarouselAdapter(singleGame.getGameCarousel(), getActivity());
            carouselRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
            carouselRecycler.setAdapter(carouselAdapter);
        }
    }
}
