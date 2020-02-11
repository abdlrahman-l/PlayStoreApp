package com.example.tabgoplayactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.model.SingleGameModel;
import com.example.tabgoplayactivity.model.SingleMovieModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewTopMoviesAdapter extends RecyclerView.Adapter<RecyclerViewTopMoviesAdapter.RowHolder> {

    private ArrayList<SingleMovieModel> topMoviesList;
    private Context mContext;

    public RecyclerViewTopMoviesAdapter(ArrayList<SingleMovieModel> topMoviesList, Context mContext) {
        this.topMoviesList = topMoviesList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_top_movies,null);
        RowHolder holder = new RowHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        SingleMovieModel topMovie = topMoviesList.get(position);
        holder.titleMovie.setText(topMovie.getTitle());
        holder.categoryMovie.setText(topMovie.getCategory());
        holder.ratingMovie.setText(topMovie.getRating());
        holder.priceMovie.setText(topMovie.getPrice());
        holder.imageMovie.setImageResource(topMovie.getImage());
        holder.numberTopMovies.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return (null != topMoviesList ? topMoviesList.size() : 0);
    }

    public class RowHolder extends RecyclerView.ViewHolder {

        protected TextView titleMovie, categoryMovie, ratingMovie, priceMovie, numberTopMovies;
        protected ImageView imageMovie;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
            numberTopMovies = itemView.findViewById(R.id.number_top_movies);
            titleMovie = itemView.findViewById(R.id.title_movie);
            categoryMovie = itemView.findViewById(R.id.category_movie);
            ratingMovie = itemView.findViewById(R.id.rating_movie);
            priceMovie = itemView.findViewById(R.id.price_movie);
            imageMovie = itemView.findViewById(R.id.image_movie);
        }
    }
}
