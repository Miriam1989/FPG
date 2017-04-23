package com.fpg.fpg.services;

import com.fpg.fpg.models.OnBoarding;

import java.util.List;

/**
 * Created by jhovany on 16/04/17.
 */

public class SplashServices {
    public void setItemOnBoarding(List<OnBoarding> responceList) {
        OnBoarding.deleteAll(OnBoarding.class);
        for (OnBoarding item : responceList) {
            item.save();
        }

    }
}
