package com.fpg.fpg.services;

import com.fpg.fpg.models.News;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

/**
 * Created by jhovany on 16/04/17.
 */

public class NewsServices {

    public List<News> getNewsByGroup(Long idGroup) {
        return Select.from(News.class).where(Condition.prop("GROUP_NEWS").eq(idGroup)).list();
    }

}
