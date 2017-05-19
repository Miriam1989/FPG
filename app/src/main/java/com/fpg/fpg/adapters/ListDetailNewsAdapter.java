package com.fpg.fpg.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fpg.fpg.R;
import com.fpg.fpg.models.News;
import com.fpg.fpg.utils.Constants;

import java.util.List;

/**
 * Created by jhovany on 27/03/17.
 */

public class ListDetailNewsAdapter extends RecyclerView.Adapter<ListDetailNewsAdapter.ListDetailNewsViewHolder> {

    private List<News> newsList;
    private int viewPosition = 0;
    private Context context;

    public ListDetailNewsAdapter(List<News> newsList, Context context) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public ListDetailNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (newsList.get(viewPosition).getTypeCard().getNameCardType().equals("DETAIL_V1")) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_details_v1, parent, false);
            viewPosition++;
        }
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

    public class ListDetailNewsViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private ImageView iv_banner;
        private TextView tv_description_detail;

        public ListDetailNewsViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            iv_banner = (ImageView) itemView.findViewById(R.id.iv_detail);
            tv_description_detail = (TextView) itemView.findViewById(R.id.tv_description_detail);
        }

        private void bindViewHolder(News news) {
            tv_title.setText(news.getTitle());

            if (news.getImage().equals("------") || news.getImage().equals("")) {

                RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                layout.height = (int) 200.0f;
                iv_banner.setLayoutParams(layout);
                Glide.with(context).load(R.drawable.ic_place_holder).into(iv_banner);
            } else {
                Glide.with(context)
                        .load(Constants.GoogleDrive.DRIVE_IMAGE_ROUTE + news.getImage())
                        .placeholder(R.drawable.ic_place_holder)
                        .crossFade()
                        .dontTransform()
                        .into(iv_banner);

            }
            tv_description_detail.setText(news.getDescription());
        }
    }
}



