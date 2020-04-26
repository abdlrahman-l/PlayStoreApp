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
import com.example.tabgoplayactivity.adapter.DescriptionDetailsAdapter;
import com.example.tabgoplayactivity.listener.YoutubePlayerListener;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.example.tabgoplayactivity.utils.DataUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private SingleGameModel singleGame;
    private TextView detailName,detailName2;
    private ImageView iconDetail;
    private RecyclerView carouselRecycler;
    private RecyclerView descRecycler;
    private YouTubePlayerView youTubePlayerVieww;
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
        descRecycler = view.findViewById(R.id.desc_recycler);
        carouselRecycler = view.findViewById(R.id.carousel_recycler);
        carouselRecycler.setHasFixedSize(true);
        descRecycler.setHasFixedSize(true);
        singleGame = ((DetailsActivity)getActivity()).getSingleGame();
        detailName.setText(singleGame.getGameName());
        detailName2.setText(singleGame.getGameName());
        iconDetail.setImageResource(singleGame.getGameIcon());

        DescriptionDetailsAdapter descriptionDetailsAdapter = new DescriptionDetailsAdapter(singleGame,getActivity(),DataUtils.getGamesDescIcon(getActivity()));
        descRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        descRecycler.setAdapter(descriptionDetailsAdapter);

        if (singleGame.getGameCarousel() != null){
            CarouselAdapter carouselAdapter = new CarouselAdapter(singleGame.getGameCarousel(), getActivity(), this, new YoutubePlayerListener() {
                @Override
                public void onClick(YouTubePlayerView youTubePlayerView) {
                    youTubePlayerVieww = youTubePlayerView;
                }
            });
            carouselAdapter.setVideoId("O4HRfSmkTv4");
            carouselRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
            carouselRecycler.setAdapter(carouselAdapter);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (youTubePlayerVieww != null)
            youTubePlayerVieww.release();
    }
}
