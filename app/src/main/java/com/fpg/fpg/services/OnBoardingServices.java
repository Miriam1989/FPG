package com.fpg.fpg.services;

import com.fpg.fpg.models.OnBoarding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhovany on 27/03/17.
 */

public class OnBoardingServices {

    public List<OnBoarding> getView() {
        List<OnBoarding> listItems = new ArrayList<>();

        OnBoarding itemDance = new OnBoarding();
        itemDance.setBoardingName("Danza");
        itemDance.setBoardDescription("Descripción");
        itemDance.setBoardImage(null);
        itemDance.setBoardCircleColor("");
        itemDance.setBoardingOrder(1);

        OnBoarding itemMusic = new OnBoarding();
        itemMusic.setBoardingName("Música");
        itemMusic.setBoardDescription("Descripción");
        itemMusic.setBoardImage(null);
        itemMusic.setBoardCircleColor("");
        itemMusic.setBoardingOrder(2);

        OnBoarding itemEnglish = new OnBoarding();
        itemEnglish.setBoardingName("Ingles");
        itemEnglish.setBoardDescription("Descripción");
        itemEnglish.setBoardImage(null);
        itemEnglish.setBoardCircleColor("");
        itemEnglish.setBoardingOrder(3);

        OnBoarding itemSwimming = new OnBoarding();
        itemSwimming.setBoardingName("Natacióm");
        itemSwimming.setBoardDescription("Descripción");
        itemSwimming.setBoardImage(null);
        itemSwimming.setBoardCircleColor("");
        itemSwimming.setBoardingOrder(4);

        OnBoarding itemHumanFormation = new OnBoarding();
        itemHumanFormation.setBoardingName("Formación Humana");
        itemHumanFormation.setBoardDescription("Descripción");
        itemHumanFormation.setBoardImage(null);
        itemHumanFormation.setBoardCircleColor("");
        itemHumanFormation.setBoardingOrder(5);

        OnBoarding itemHumanValues = new OnBoarding();
        itemHumanValues.setBoardingName("Valores Humanos");
        itemHumanValues.setBoardDescription("Descripción");
        itemHumanValues.setBoardImage(null);
        itemHumanValues.setBoardCircleColor("");
        itemHumanValues.setBoardingOrder(6);

        OnBoarding itemTransport = new OnBoarding();
        itemTransport.setBoardingName("Transporte");
        itemTransport.setBoardDescription("Descripción");
        itemTransport.setBoardImage(null);
        itemTransport.setBoardCircleColor("");
        itemTransport.setBoardingOrder(7);

        listItems.add(itemDance);
        listItems.add(itemMusic);
        listItems.add(itemEnglish);
        listItems.add(itemSwimming);
        listItems.add(itemHumanFormation);
        listItems.add(itemHumanValues);
        listItems.add(itemTransport);
        return listItems;
    }

}
