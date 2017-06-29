package com.fpg.fpg.services;

import android.text.TextUtils;

import com.fpg.fpg.models.DateNews;
import com.fpg.fpg.models.GroupNews;
import com.fpg.fpg.models.News;
import com.fpg.fpg.ws.pojo.GroupNewsWS;
import com.orm.query.Condition;
import com.orm.query.Select;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by jhovany on 16/04/17.
 */

public class NewsServices {

    public List<News> getNewsByGroup(Long idGroup) {
        return Select.from(News.class).where(Condition.prop("GROUP_NEWS").eq(idGroup)).list();
    }

    public String getDateBar(Long idGroup) {
        GroupNews groupNews = Select.from(GroupNews.class).where(Condition.prop("DATE_NEWS").eq(idGroup)).first();
        DateNews dateNews = Select.from(DateNews.class).where(Condition.prop("REMOTE_ID").eq(groupNews.getDateNews())).first();

        String day;
        if (TextUtils.isEmpty(dateNews.getFinishDay())) {
            day = dateNews.getStartDay();
        } else {
            day = dateNews.getStartDay() + " al " + dateNews.getFinishDay() ;
        }
        return day +" de "+ StringUtils.capitalize(dateNews.getMonth().toLowerCase());
    }
}
