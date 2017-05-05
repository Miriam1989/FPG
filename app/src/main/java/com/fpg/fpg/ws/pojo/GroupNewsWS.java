package com.fpg.fpg.ws.pojo;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by jhovany on 27/03/17.
 */

public class GroupNewsWS extends SugarRecord {

    private Long dateNews;
    private List<NewsWS> newsList;
    private Long remoteId;
    private Long remoteIdTypeCard;

    public GroupNewsWS() {
    }

    public Long getDateNews() {
        return dateNews;
    }

    public void setDateNews(Long dateNews) {
        this.dateNews = dateNews;
    }

    public List<NewsWS> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsWS> newsList) {
        this.newsList = newsList;
    }

    public Long getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(Long remoteId) {
        this.remoteId = remoteId;
    }

    public Long getRemoteIdTypeCard() {
        return remoteIdTypeCard;
    }

    public void setRemoteIdTypeCard(Long remoteIdTypeCard) {
        this.remoteIdTypeCard = remoteIdTypeCard;
    }
}
