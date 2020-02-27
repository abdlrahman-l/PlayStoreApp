package com.example.tabgoplayactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tabgoplayactivity.BottomSheetDialog;
import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.model.SingleMovieModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class SectionListMovieAdapter extends RecyclerView.Adapter<SectionListMovieAdapter.RowHolder> {

    private ArrayList<SingleMovieModel> movieList;
    private Context mContext;
    private FragmentManager fm;

    public SectionListMovieAdapter(ArrayList<SingleMovieModel> movieList, Context mContext, FragmentManager fm) {
        this.movieList = movieList;
        this.mContext = mContext;
        this.fm = fm;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_movie,null);
        RowHolder rowHolder = new RowHolder(v);
        return rowHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        final SingleMovieModel singleMovie = movieList.get(position);
        holder.titleMovie.setText(singleMovie.getTitle());
        holder.ratingMovie.setText(singleMovie.getRating());
        holder.priceMovie.setText(singleMovie.getPrice());
        holder.imageMovie.setImageResource(singleMovie.getImage());
    }

    @Override
    public int getItemCount() {
        return (null != movieList ? movieList.size() : 0);
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        protected TextView titleMovie, ratingMovie, priceMovie;
        protected ImageView imageMovie;
        protected LinearLayout movieContainer;
        public RowHolder(@NonNull View itemView) {
            super(itemView);
            titleMovie = itemView.findViewById(R.id.title_movie);
            ratingMovie = itemView.findViewById(R.id.rating_movie);
            priceMovie = itemView.findViewById(R.id.price_movie);
            imageMovie = itemView.findViewById(R.id.image_movie);
            movieContainer = itemView.findViewById(R.id.single_movie_container);
            movieContainer.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    BottomSheetDialog dialog = new BottomSheetDialog();
                    dialog.setSingleMovie(movieList.get(getAdapterPosition()));
                    dialog.show(fm,"test");
                    return true;
                }
            });
        }
    }
}
