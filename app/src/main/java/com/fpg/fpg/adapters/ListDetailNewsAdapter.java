package com.fpg.fpg.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fpg.fpg.R;
import com.fpg.fpg.models.News;

import java.util.List;

/**
 * Created by jhovany on 27/03/17.
 */

public class ListDetailNewsAdapter extends RecyclerView.Adapter<ListDetailNewsAdapter.ListDetailNewsViewHolder> {

    private List<News> newsList;
    private boolean flag = true;
    private int viewPosition = 0;
    private Context context;

    public ListDetailNewsAdapter(List<News> newsList, Context context) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public ListDetailNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        //   if (newsList.get(viewPosition).getTypeCard().getNameCardType().equals("CARD")) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_calendar, parent, false);
        viewPosition++;
        // }
        return new ListDetailNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListDetailNewsViewHolder holder, int position) {
        holder.bindViewHolder(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    protected class ListDetailNewsViewHolder extends RecyclerView.ViewHolder {

        public ListDetailNewsViewHolder(View itemView) {
            super(itemView);
        }

        private void bindViewHolder(News news) {

        }
    }
}



