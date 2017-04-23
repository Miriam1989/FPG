package com.fpg.fpg.services;

import com.fpg.fpg.models.OnBoarding;
import com.orm.query.Select;

import java.util.List;

/**
 * Created by jhovany on 27/03/17.
 */

public class OnBoardingServices {

    public List<OnBoarding> getView() {
/*
        itemDance.setBoardCircleColor("#d71860"); //#d71860  //#890b4f
        itemMusic.setBoardCircleColor("#3848a8"); //#3848a8 //#1a227c
        itemEnglish.setBoardCircleColor("#5e35b1"); //5e35b1  //311b92
        itemSwimming.setBoardCircleColor("#61b4f5"); //#61b4f5  //#2494f0
        itemHumanFormation.setBoardCircleColor("#ed6b03"); //#ed6b03  //#f88c01
        itemHumanValues.setBoardCircleColor("#d71760"); //#d71760
        itemTransport.setBoardCircleColor("#ad0807"); //#ad0807   //#8f0403
        */
        // String query = "Select * from ON_BOARDING ORDER BY BOARDING_ORDER ASC";
        //return OnBoarding.findWithQuery(OnBoarding.class, query);
        return Select.from(OnBoarding.class).list();
    }

}
