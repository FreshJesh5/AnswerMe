package com.freshjesh.answerme.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.freshjesh.answerme.Model.Player;
import com.freshjesh.answerme.R;

import java.util.ArrayList;

/**
 * Created by joshc on 7/25/2017.
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private ArrayList<Player> mDataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            textView = v.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public PlayerAdapter(ArrayList<Player> dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.player_list_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setText(mDataSet.get(position).username);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}
