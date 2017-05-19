package com.fpg.fpg.services;

import com.fpg.fpg.models.DateNews;
import com.fpg.fpg.models.GroupNews;
import com.fpg.fpg.models.News;
import com.fpg.fpg.models.OnBoarding;
import com.fpg.fpg.models.TypeCard;
import com.fpg.fpg.ws.fpgServices;
import com.fpg.fpg.ws.pojo.DateNewsWS;
import com.fpg.fpg.ws.pojo.GroupNewsWS;
import com.fpg.fpg.ws.pojo.NewsWS;
import com.fpg.fpg.ws.pojo.TypeCardWS;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jhovany on 27/04/17.
 */

public class SyncUp {
    private SplashServices splashServices;

    public SyncUp() {

    }

    public void getOnBoardingData() {
        fpgServices.getServices().index().enqueue(new Callback<List<OnBoarding>>() {
            @Override
            public void onResponse(Call<List<OnBoarding>> call, Response<List<OnBoarding>> response) {
                splashServices = new SplashServices();
                splashServices.setItemOnBoarding(response.body());
                getTypeCard();
            }

            @Override
            public void onFailure(Call<List<OnBoarding>> call, Throwable t) {

            }
        });
    }

    private void getTypeCard() {
        fpgServices.getServices().getTypeCard().enqueue(new Callback<List<TypeCardWS>>() {
            @Override
            public void onResponse(Call<List<TypeCardWS>> call, Response<List<TypeCardWS>> response) {

                List<TypeCard> referenceTypeCard = Select.from(TypeCard.class).list();
                HashMap<String, TypeCard> hmItem = new HashMap<>();

                for (TypeCard typeCard : referenceTypeCard) {
                    hmItem.put(String.valueOf(typeCard.getRemoteId()), typeCard);
                }

                for (TypeCardWS typeCardWS : response.body()) {

                    TypeCard typeCard = Select.from(TypeCard.class).where(Condition.prop("REMOTE_ID").eq(typeCardWS.getRemoteId())).first();
                    if (typeCard == null) {
                        typeCard = new TypeCard();
                    }
                    typeCard.setRemoteId(typeCardWS.getRemoteId());
                    typeCard.setNameCardType(typeCardWS.getNameCardType());
                    typeCard.save();

                    hmItem.remove(String.valueOf(typeCardWS.getRemoteId()));
                }

                for (Map.Entry<String, TypeCard> deleteTypeCard : hmItem.entrySet()) {
                    deleteTypeCard.getValue().delete();
                }
                getDateNews();

            }

            @Override
            public void onFailure(Call<List<TypeCardWS>> call, Throwable t) {
            }
        });
    }


    private void getDateNews() {
        fpgServices.getServices().getDateNews().enqueue(new Callback<List<DateNewsWS>>() {
            @Override
            public void onResponse(Call<List<DateNewsWS>> call, Response<List<DateNewsWS>> response) {

                List<DateNews> referenceDateNews = Select.from(DateNews.class).list();
                HashMap<String, DateNews> hmItem = new HashMap<>();
                for (DateNews dateNews : referenceDateNews) {
                    hmItem.put(String.valueOf(dateNews.getRemoteId()), dateNews);
                }

                for (DateNewsWS dateNewsWS : response.body()) {
                    DateNews dateNews = Select.from(DateNews.class).where(Condition.prop("REMOTE_ID").eq(dateNewsWS.getRemoteId())).first();
                    if (dateNews == null) {
                        dateNews = new DateNews();
                    }
                    dateNews.setRemoteId(dateNewsWS.getRemoteId());
                    dateNews.setStartDay(dateNewsWS.getStartDay());
                    dateNews.setFinishDay(dateNewsWS.getFinishDay());
                    dateNews.setMonth(dateNewsWS.getMonth());
                    dateNews.setYear(dateNewsWS.getYear());
                    dateNews.save();

                    hmItem.remove(String.valueOf(dateNewsWS.getRemoteId()));
                }
                for (Map.Entry<String, DateNews> deleteDateNews : hmItem.entrySet()) {
                    deleteDateNews.getValue().delete();
                }
                getGroupNews();

            }

            @Override
            public void onFailure(Call<List<DateNewsWS>> call, Throwable t) {
            }
        });
    }

    private void getGroupNews() {
        fpgServices.getServices().getGroupNews().enqueue(new Callback<List<GroupNewsWS>>() {
            @Override
            public void onResponse(Call<List<GroupNewsWS>> call, Response<List<GroupNewsWS>> response) {
                List<GroupNews> referenceGroupNews = Select.from(GroupNews.class).list();
                HashMap<String, GroupNews> hmItem = new HashMap<>();
                for (GroupNews groupNews : referenceGroupNews) {
                    hmItem.put(String.valueOf(groupNews.getRemoteId()), groupNews);
                }

                for (GroupNewsWS groupNewsWS : response.body()) {
                    GroupNews groupNews = Select.from(GroupNews.class).where(Condition.prop("REMOTE_ID").eq(groupNewsWS.getRemoteId())).first();

                    if (groupNews == null) {
                        groupNews = new GroupNews();
                    }

                    DateNews dateNews = Select.from(DateNews.class).where(Condition.prop("REMOTE_ID").eq(groupNewsWS.getDateNews())).first();
                    if (dateNews != null) {
                        groupNews.setDateNews(dateNews);
                    }
                    TypeCard typeCard = Select.from(TypeCard.class).where(Condition.prop("REMOTE_ID").eq(groupNewsWS.getRemoteIdTypeCard())).first();

                    if (typeCard != null) {
                        groupNews.setTypeCard(typeCard);
                    }
                    groupNews.setRemoteId(groupNewsWS.getRemoteId());

                    groupNews.save();

                    hmItem.remove(String.valueOf(groupNews.getRemoteId()));
                }

                for (Map.Entry<String, GroupNews> deleteGroupNews : hmItem.entrySet()) {
                    deleteGroupNews.getValue().delete();
                }
                getNews();
            }

            @Override
            public void onFailure(Call<List<GroupNewsWS>> call, Throwable t) {
            }
        });
    }

    private void getNews() {
        fpgServices.getServices().getNews().enqueue(new Callback<List<NewsWS>>() {
            @Override
            public void onResponse(Call<List<NewsWS>> call, Response<List<NewsWS>> response) {
                List<News> referenceNews = Select.from(News.class).list();
                HashMap<String, News> hmItem = new HashMap<>();

                for (News newsElement : referenceNews) {
                    hmItem.put(String.valueOf(newsElement.getRemoteId()), newsElement);
                }

                for (NewsWS newsWS : response.body()) {

                    News newsElement = Select.from(News.class).where(Condition.prop("REMOTE_ID").eq(newsWS.getRemoteId())).first();
                    if (newsElement == null) {
                        newsElement = new News();
                    }
                    newsElement.setRemoteId(newsWS.getRemoteId());
                    newsElement.setTitle(newsWS.getTitle());
                    newsElement.setShortTitle(newsWS.getShortTitle());
                    newsElement.setImage(newsWS.getImage());
                    newsElement.setDescription(newsWS.getDescription());
                    newsElement.setOrderItem(newsWS.getOrder());

                    TypeCard typeCard = Select.from(TypeCard.class).where(Condition.prop("REMOTE_ID").eq(newsWS.getRemoteIdTypeCard())).first();

                    if (typeCard != null) {
                        newsElement.setTypeCard(typeCard);
                    }

                    GroupNews groupNews = Select.from(GroupNews.class).where(Condition.prop("REMOTE_ID").eq(newsWS.getRemoteGroupId())).first();
                    if (groupNews != null) {
                        newsElement.setGroupNews(groupNews);
                    }

                    DateNews dateNews = Select.from(DateNews.class).where(Condition.prop("REMOTE_ID").eq(newsWS.getDate())).first();
                    newsElement.setDateNews(dateNews);
                    newsElement.save();
                    hmItem.remove(String.valueOf(newsElement.getRemoteId()));

                }
                for (Map.Entry<String, News> deleteNews : hmItem.entrySet()) {
                    deleteNews.getValue().delete();
                }
            }

            @Override
            public void onFailure(Call<List<NewsWS>> call, Throwable t) {
            }
        });
    }


}
