package com.example.tabgoplayactivity.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.listener.ClickListener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryTopRecyclerView extends RecyclerView.Adapter<CategoryTopRecyclerView.ViewHolder> {

    private final ClickListener listener;
    private ArrayList<String> topCategoryName;
    private Context mContext;
    private int buttonState = 1;

    public CategoryTopRecyclerView(ArrayList<String> topCategoryName, Context mContext, ClickListener listener){
        this.topCategoryName = topCategoryName;
        this.mContext = mContext;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_category_top_games,null,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.btnTopCategory.setText(topCategoryName.get(position));
    }

    @Override
    public int getItemCount() {
        return (null != topCategoryName ? topCategoryName.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected Button btnTopCategory;
        private WeakReference<ClickListener> listenerRef;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listenerRef = new WeakReference<>(listener);
            btnTopCategory = itemView.findViewById(R.id.btn_top_category);
            btnTopCategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listenerRef.get().onPositionClicked(getAdapterPosition());
                }
            });
        }
    }

    public ArrayList<String> getTopCategoryName() {
        return topCategoryName;
    }

    public void setTopCategoryName(ArrayList<String> topCategoryName) {
        this.topCategoryName = topCategoryName;
    }
}
