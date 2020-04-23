package com.example.tabgoplayactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.model.SingleGameModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselSingleHolder> {

    private ArrayList<Integer> idDrawableList;
    private Context context;

    public CarouselAdapter(ArrayList<Integer> idDrawableList, Context context) {
        this.idDrawableList = idDrawableList;
        this.context = context;
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
        holder.imageCarousel.setImageResource(idDrawableList.get(position));
    }

    @Override
    public int getItemCount() {
        return (null != idDrawableList ? idDrawableList.size() : 0 );
    }

    public class CarouselSingleHolder extends RecyclerView.ViewHolder{
        protected ImageView imageCarousel;
        public CarouselSingleHolder(@NonNull View itemView) {
            super(itemView);
            imageCarousel = itemView.findViewById(R.id.image_carousel_details);
        }
    }
}
