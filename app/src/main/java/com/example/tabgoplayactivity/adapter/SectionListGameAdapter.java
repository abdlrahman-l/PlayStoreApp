package com.example.tabgoplayactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tabgoplayactivity.BottomSheetDialog;
import com.example.tabgoplayactivity.R;
import com.example.tabgoplayactivity.listener.ClickListener;
import com.example.tabgoplayactivity.model.SingleGameModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class SectionListGameAdapter extends RecyclerView.Adapter<SectionListGameAdapter.SingleGameRowHolder> {

    private ArrayList<SingleGameModel> gameList;
    private Context mContext;
    private FragmentManager fm;
    private ClickListener listener;

    public SectionListGameAdapter(ArrayList<SingleGameModel> gameList, Context mContext, FragmentManager fm, ClickListener listener) {
        this.gameList = gameList;
        this.mContext = mContext;
        this.fm = fm;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SingleGameRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_game,null);
        SingleGameRowHolder singleGameRowHolder = new SingleGameRowHolder(v);
        return singleGameRowHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull SingleGameRowHolder holder, int position)  {
        final SingleGameModel singleGame = gameList.get(position);
        holder.gameName.setText(singleGame.getGameName());
        holder.gameSize.setText(singleGame.getGameSize());
    }

    @Override
    public int getItemCount() {
        return (null != gameList ? gameList.size() : 0);
    }

    public class SingleGameRowHolder extends RecyclerView.ViewHolder {
        protected TextView gameName;
        protected TextView gameSize;
        protected LinearLayout gameContainer;
        protected WeakReference<ClickListener> listenerRef;

        public SingleGameRowHolder(@NonNull View itemView) {
            super(itemView);
            this.listenerRef = new WeakReference<>(listener);
            this.gameName = itemView.findViewById(R.id.game_title);
            this.gameSize = itemView.findViewById(R.id.game_size);
            this.gameContainer = itemView.findViewById(R.id.single_game_container);
            this.gameContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listenerRef.get().onPositionClicked(getAdapterPosition());
                }
            });
            this.gameContainer.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    BottomSheetDialog dialog = new BottomSheetDialog();
                    dialog.setSingleGame(gameList.get(getAdapterPosition()));
                    dialog.show(fm,"test");
                    return true;
                }
            });
        }
    }
}
