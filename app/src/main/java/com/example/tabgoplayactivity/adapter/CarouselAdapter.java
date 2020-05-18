package com.example.tabgoplayactivity.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.listener.YoutubePlayerListener;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.jetbrains.annotations.NotNull;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselSingleHolder> {

    private ArrayList<Integer> idDrawableList;
    private Context context;
    private String videoId;
    DisplayMetrics displayMetrics = new DisplayMetrics();
    private Fragment thisFragment;
    private YoutubePlayerListener listener;

    public CarouselAdapter(ArrayList<Integer> idDrawableList, Context context, Fragment fragment, YoutubePlayerListener listener) {
        this.idDrawableList = idDrawableList;
        this.context = context;
        thisFragment = fragment;
        this.listener = listener;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @NonNull
    @Override
    public CarouselSingleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carousel_layout,null);
        CarouselSingleHolder carouselSingleHolder = new CarouselSingleHolder(v);
        return carouselSingleHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselSingleHolder holder, int position) {
        if (position == 0 && videoId != null){
            ((Activity) holder.youTubePlayerView.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels;
//            Glide.with(holder.youTubePlayerView.getContext()).load(idDrawableList.get(0)).into(holder.youtubeThumbnail);
            holder.youtubeThumbnail.setImageResource(idDrawableList.get(0));
            holder.youtubeContainer.setVisibility(View.VISIBLE);
            holder.thumbnailContainer.setVisibility(View.VISIBLE);
            holder.playButton.setOnClickListener(view -> {
                holder.youtubeThumbnail.setVisibility(View.GONE);
                holder.thumbnailContainer.setVisibility(View.GONE);
                holder.playContainer.setVisibility(View.GONE);
                holder.youTubePlayerView.setVisibility(View.VISIBLE);
                holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                        youTubePlayer.loadVideo(videoId, 0);
                        listener.onClick(holder.youTubePlayerView);
                    }
                });
            });
        }else{
            holder.carouselContainer.setVisibility(View.VISIBLE);
            holder.imageCarousel.setImageResource(idDrawableList.get(position-1));
        }
    }

    @Override
    public int getItemCount() {
        if (videoId == null)
        return (null != idDrawableList ? idDrawableList.size() : 0 );
        return (null != idDrawableList ? idDrawableList.size()+1 : 1 );
    }

    public class CarouselSingleHolder extends RecyclerView.ViewHolder{
        protected ImageView imageCarousel;
        protected RelativeLayout youtubeContainer;
        protected CardView carouselContainer;
        protected CardView thumbnailContainer;
        protected ImageView youtubeThumbnail;
        protected YouTubePlayerView youTubePlayerView;
        protected FrameLayout playContainer;
        protected ImageView playButton;
        protected WeakReference<YoutubePlayerListener> listenerRef;

        public CarouselSingleHolder(@NonNull View itemView) {
            super(itemView);
            imageCarousel = itemView.findViewById(R.id.image_carousel_details);
            youtubeContainer = itemView.findViewById(R.id.youtube_container);
            carouselContainer = itemView.findViewById(R.id.carousel_details_container);
            youtubeThumbnail = itemView.findViewById(R.id.youtube_thumbnail);
            thumbnailContainer = itemView.findViewById(R.id.youtube_thumbnai_container);
            youTubePlayerView = itemView.findViewById(R.id.youtube_view);
            playContainer = itemView.findViewById(R.id.frame_play_container);
            playButton = itemView.findViewById(R.id.play_button);
            listenerRef = new WeakReference<>(listener);
        }
    }
}
