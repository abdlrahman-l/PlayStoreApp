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
import com.example.tabgoplayactivity.utils.DataUtils;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DescriptionDetailsAdapter extends RecyclerView.Adapter<DescriptionDetailsAdapter.SingleHolder> {

    private SingleGameModel gameModel;
    private SingleMovieModel movieModel;
    private Context context;
    private ArrayList<Integer> idDescIcon;

    public DescriptionDetailsAdapter(SingleGameModel gameModel, Context context, ArrayList<Integer> idDescIcon) {
        this.gameModel = gameModel;
        this.context = context;
        this.idDescIcon = idDescIcon;
    }

    @NonNull
    @Override
    public DescriptionDetailsAdapter.SingleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_desc_details,parent,false);
        SingleHolder singleHolder = new SingleHolder(v);
        return singleHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DescriptionDetailsAdapter.SingleHolder holder, int position) {
        switch (position){
            case 0:
                holder.leftDesc.setText(String.valueOf(gameModel.getGameRating()));
                holder.midIcon.setImageResource(idDescIcon.get(1));
                holder.rightDesc.setVisibility(View.GONE);
                holder.bottomDesc.setText("230 K reviews");
                break;
            case 1:
                holder.leftDesc.setVisibility(View.GONE);
                holder.midIcon.setImageResource(idDescIcon.get(2));
                holder.rightDesc.setVisibility(View.GONE);
                holder.bottomDesc.setText(gameModel.getGameSize());
                break;
            case 2:
                holder.leftDesc.setText("15");
                holder.midIcon.setImageResource(idDescIcon.get(0));
                holder.rightDesc.setVisibility(View.GONE);
                holder.bottomDesc.setText("Rated for 15+");
                break;
            case 3:
                holder.leftDesc.setText("4M");
                holder.midIcon.setImageResource(idDescIcon.get(0));
                holder.rightDesc.setVisibility(View.GONE);
                holder.bottomDesc.setText("Downloads");
                holder.lineEnd.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class SingleHolder extends RecyclerView.ViewHolder {
        protected TextView leftDesc;
        protected ImageView midIcon;
        protected TextView rightDesc;
        protected TextView bottomDesc;
        protected View lineEnd;

        public SingleHolder(@NonNull View itemView) {
            super(itemView);
            leftDesc = itemView.findViewById(R.id.left_desc_text);
            midIcon = itemView.findViewById(R.id.mid_desc_icon);
            rightDesc = itemView.findViewById(R.id.right_desc_text);
            bottomDesc = itemView.findViewById(R.id.bot_desc_text);
            lineEnd = itemView.findViewById(R.id.line_end);
        }
    }
}
