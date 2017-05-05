package com.fpg.fpg.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fpg.fpg.R;
import com.fpg.fpg.models.GroupNews;
import com.fpg.fpg.models.News;
import com.fpg.fpg.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhovany on 27/03/17.
 */

public class ListHeaderNewsAdapter extends RecyclerView.Adapter<ListHeaderNewsAdapter.ListHeaderNewsViewHolder> {

    private List<GroupNews> groupNewsList;
    private boolean flag = true;
    private int viewPosition = 0;
    private Context context;

    public ListHeaderNewsAdapter(List<GroupNews> groupNewsList, Context context) {
        this.context = context;
        this.groupNewsList = groupNewsList;
    }

    @Override
    public ListHeaderNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (groupNewsList.get(viewPosition).getTypeCard().getNameCardType().equals("CARD")) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_calendar, parent, false);
            viewPosition++;
        } else if (groupNewsList.get(viewPosition).getTypeCard().getNameCardType().equals("BANNER")) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_headline, parent, false);
            viewPosition++;
        } else if (groupNewsList.get(viewPosition).getTypeCard().getNameCardType().equals("CARD_V2")) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_calendar_v_2, parent, false);
            viewPosition++;
        }
        return new ListHeaderNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHeaderNewsViewHolder holder, int position) {
        holder.bindViewHolder(groupNewsList.get(position));
    }

    @Override
    public int getItemCount() {
        return groupNewsList.size();
    }

    protected class ListHeaderNewsViewHolder extends RecyclerView.ViewHolder {
        /*CARD*/
        public TextView tv_day;
        public TextView tv_month;
        public TextView tv_year;
        public TextView tv_more;
        public TextView tv_news_1;
        public TextView tv_news_2;
        public TextView tv_news_3;
        public TextView tv_news_4;
        /*BANNER*/
        public ImageView iv_banner;

        /*CARD V2*/
        public TextView tv_day_v2;
        public TextView tv_month_v2;
        public TextView tv_weekday;
        public TextView tv_more_v2;
        public TextView tv_news_1_v2;
        public TextView tv_news_2_v2;
        public TextView tv_news_3_v2;
        public TextView tv_news_4_v2;

        public ListHeaderNewsViewHolder(View itemView) {
            super(itemView);
            tv_day = (TextView) itemView.findViewById(R.id.tv_day);
            tv_month = (TextView) itemView.findViewById(R.id.tv_month);
            tv_year = (TextView) itemView.findViewById(R.id.tv_year);
            tv_more = (TextView) itemView.findViewById(R.id.tv_more);
            tv_news_1 = (TextView) itemView.findViewById(R.id.tv_news_1);
            tv_news_2 = (TextView) itemView.findViewById(R.id.tv_news_2);
            tv_news_3 = (TextView) itemView.findViewById(R.id.tv_news_3);
            tv_news_4 = (TextView) itemView.findViewById(R.id.tv_news_4);

            iv_banner = (ImageView) itemView.findViewById(R.id.iv_banner);

            tv_day_v2 = (TextView) itemView.findViewById(R.id.tv_day_v2);
            tv_month_v2 = (TextView) itemView.findViewById(R.id.tv_month_v2);
            tv_weekday = (TextView) itemView.findViewById(R.id.tv_weekday);
            tv_more_v2 = (TextView) itemView.findViewById(R.id.tv_more);
            tv_news_1_v2 = (TextView) itemView.findViewById(R.id.tv_news_1_v2);
            tv_news_2_v2 = (TextView) itemView.findViewById(R.id.tv_news_2_v2);
            tv_news_3_v2 = (TextView) itemView.findViewById(R.id.tv_news_3_v2);
            tv_news_4_v2 = (TextView) itemView.findViewById(R.id.tv_news_4_v2);

        }

        private void bindViewHolder(GroupNews groupNews) {

            if (groupNews.getTypeCard().getNameCardType().equals("CARD")) {
                tv_day.setText(groupNews.getDateNews().getStartDay());
                tv_month.setText(groupNews.getDateNews().getMonth());
                tv_year.setText(groupNews.getDateNews().getYear());

                List<TextView> textViews = new ArrayList<>();

                textViews.add(tv_news_1);
                textViews.add(tv_news_2);
                textViews.add(tv_news_3);
                textViews.add(tv_news_4);

                for (int index = 0; index < 4; index++) {

                    if (index < groupNews.getNews().size()) {
                        setNews(textViews.get(index), groupNews.getNews().get(index));
                        if (index == 3) {
                            tv_more.setVisibility(View.VISIBLE);
                        }
                    }
                }

            } else if (groupNews.getTypeCard().getNameCardType().equals("BANNER")) {
                Glide.with(context).load(Constants.GoogleDrive.DRIVE_IMAGE_ROUTE + groupNews.getNews().get(0).getImage()).into(iv_banner);
            } else if (groupNews.getTypeCard().getNameCardType().equals("CARD_V2")) {
                tv_day_v2.setText(groupNews.getDateNews().getStartDay());
                tv_month_v2.setText(groupNews.getDateNews().getMonth());
                //tv_weekday.setText(groupNews.getDateNews().getYear());

                List<TextView> textViews = new ArrayList<>();

                textViews.add(tv_news_1_v2);
                textViews.add(tv_news_2_v2);
                textViews.add(tv_news_3_v2);
                textViews.add(tv_news_4_v2);

                for (int index = 0; index < 4; index++) {

                    if (index < groupNews.getNews().size()) {
                        setNews(textViews.get(index), groupNews.getNews().get(index));
                        if (index == 3) {
                            tv_more.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        }
    }


    private void setNews(TextView tv, News news) {
        if (news != null) {
            tv.setText(news.getShortTitle());
            tv.setVisibility(View.VISIBLE);
        } else {
            tv.setVisibility(View.GONE);
        }
    }
}



