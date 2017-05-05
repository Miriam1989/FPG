package com.fpg.fpg.models;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by jhovany on 27/03/17.
 */

public class GroupNews extends SugarRecord {

    private Long id;
    private Long remoteId;
    private List<News> news;
    private DateNews dateNews;
    private TypeCard typeCard;

    public GroupNews() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(Long remoteId) {
        this.remoteId = remoteId;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public DateNews getDateNews() {
        return dateNews;
    }

    public void setDateNews(DateNews dateNews) {
        this.dateNews = dateNews;
    }

    public TypeCard getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(TypeCard typeCard) {
        this.typeCard = typeCard;
    }
}
