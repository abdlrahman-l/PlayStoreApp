package com.example.tabgoplayactivity;


import android.animation.LayoutTransition;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tabgoplayactivity.model.SingleMovieModel;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailsFragment extends Fragment {

    private ImageView imageMovie;
    private TextView nameMovie,categoryMovie;
    private SingleMovieModel singleMovie;
    private ImageView thumbnailMovie;
    private ImageView playButton;
    private YouTubePlayerView youTubePlayerView;
    private CardView thumbnailContainer;
    private RelativeLayout youtubeRelativeContainer;

    public MovieDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_details, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        youTubePlayerView.release();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameMovie = view.findViewById(R.id.name_movie_details);
        categoryMovie = view.findViewById(R.id.category_movie_details);
        imageMovie = view.findViewById(R.id.image_movie_details);
        thumbnailMovie = view.findViewById(R.id.youtube_thumbnail_movie);
        thumbnailContainer = view.findViewById(R.id.youtube_thumbnail_container);
        playButton = view.findViewById(R.id.play_button);
        youTubePlayerView = view.findViewById(R.id.youtube_view_movie);
        youtubeRelativeContainer = view.findViewById(R.id.youtube_relative_container);
        singleMovie = ((DetailsActivity)getActivity()).getSingleMovie();

        nameMovie.setText(singleMovie.getTitle());
        categoryMovie.setText(singleMovie.getCategory());
        imageMovie.setImageResource(singleMovie.getImage());
        thumbnailMovie.setImageResource(singleMovie.getThumbnailYoutube());
        setUpYoutubeViewer();
        expand(youtubeRelativeContainer);
    }

    private void setUpYoutubeViewer(){
//        Glide.with(youTubePlayerView.getContext()).load(singleMovie.getThumbnailYoutube()).into(thumbnailMovie);
        playButton.setOnClickListener(view -> {
            thumbnailContainer.setVisibility(View.GONE);
            youTubePlayerView.setVisibility(View.VISIBLE);
            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    youTubePlayer.loadVideo("rgXplohCw5o", 0);
                }
            });
        });
    }

    private void expand(final View v) {
        v.measure(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();
        final float EPSILON = 0.0000001f;
        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.GONE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = (Math.abs(interpolatedTime - 1f) < EPSILON)
                        ? RelativeLayout.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration(500);
        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setAnimationForThumbnail();
                thumbnailMovie.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        v.startAnimation(a);
        v.setVisibility(View.VISIBLE);

    }

    private void setAnimationForThumbnail(){
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); // add this
        fadeIn.setDuration(500);
        AnimationSet animation1 = new AnimationSet(false); // change to false
        animation1.addAnimation(fadeIn);
        animation1.setRepeatCount(1);
        thumbnailMovie.startAnimation(animation1);
    }
}
