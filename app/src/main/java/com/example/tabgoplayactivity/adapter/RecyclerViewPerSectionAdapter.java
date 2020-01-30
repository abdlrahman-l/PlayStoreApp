package com.example.tabgoplayactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.model.SectionDataGameModel;
import com.example.tabgoplayactivity.model.SingleGameModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewPerSectionAdapter extends RecyclerView.Adapter<RecyclerViewPerSectionAdapter.ItemRowHolder> {

    private ArrayList<SectionDataGameModel> dataList;
    private Context mContext;

    public RecyclerViewPerSectionAdapter(ArrayList<SectionDataGameModel> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_game,null);
        ItemRowHolder itemRowHolder = new ItemRowHolder(v);
        return itemRowHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRowHolder holder, int position) {
        final String sectionName = dataList.get(position).getHeaderTitle();
        ArrayList<SingleGameModel> singleSectionGames = dataList.get(position).getAllItemsInSection();
        holder.sectionTitle.setText(dataList.get(position).getHeaderTitle());
        SectionListGameAdapter sectionListGameAdapter = new SectionListGameAdapter(singleSectionGames,mContext);
        holder.sectionGameRecyclerView.setHasFixedSize(true);
        holder.sectionGameRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        holder.sectionGameRecyclerView.setAdapter(sectionListGameAdapter);

        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"test "+sectionName,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView sectionTitle;
        protected RecyclerView sectionGameRecyclerView;
        protected Button btnMore;

        public ItemRowHolder(@NonNull View itemView) {
            super(itemView);
            this.sectionTitle = itemView.findViewById(R.id.item_title);
            this.sectionGameRecyclerView = itemView.findViewById(R.id.game_recycler_view);
            this.btnMore = itemView.findViewById(R.id.btn_more);
        }
    }
}
