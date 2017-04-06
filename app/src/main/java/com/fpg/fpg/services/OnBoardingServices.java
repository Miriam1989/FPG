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
        itemDance.setBoardDescription(
                "Es un lenguaje expresivo, que se vale de movimientos corporales cargados de emoción para expresar y comunicar, generalmente es acompañada de música. Los movimientos están guiados por una energía específica distinta en cada situacioón y llevan una musucalidad y ritmo que le da orden al movimiento.");
        itemDance.setBoardImage("0B6xyiWpZ8iAFN2dSVFJld1JjVHM");
        itemDance.setBoardCircleColor("#d71860"); //#d71860  //#890b4f
        itemDance.setBoardingOrder(1);

        OnBoarding itemMusic = new OnBoarding();
        itemMusic.setBoardingName("Música");
        itemMusic.setBoardDescription("" +
                "Se encuentra en el marco del desarrollo psicomotriz del niño, por lo tanto es determinante para elaborar cualquier " +
                "planteamiento educativo musical, se enriquecen a partir del movimiento, desde la escucha activa a través del cuerpo, los juegos con posiciones, la construcción de instrumentos, etc.");
        itemMusic.setBoardImage("0B6xyiWpZ8iAFZDlaRU5DV25EbEE");
        itemMusic.setBoardCircleColor("#3848a8"); //#3848a8 //#1a227c
        itemMusic.setBoardingOrder(2);

        OnBoarding itemEnglish = new OnBoarding();
        itemEnglish.setBoardingName("Ingles");
        itemEnglish.setBoardDescription("Descripción");
        itemEnglish.setBoardImage("0B6xyiWpZ8iAFTTdiRmpxWFhmRUU");
        itemEnglish.setBoardCircleColor("#5e35b1"); //5e35b1  //311b92
        itemEnglish.setBoardingOrder(3);

        OnBoarding itemSwimming = new OnBoarding();
        itemSwimming.setBoardingName("Natación");
        itemSwimming.setBoardDescription("Descripción");
        itemSwimming.setBoardImage("0B6xyiWpZ8iAFalBFaE5mVnFVUXc");
        itemSwimming.setBoardCircleColor("#61b4f5"); //#61b4f5  //#2494f0
        itemSwimming.setBoardingOrder(4);

        OnBoarding itemHumanFormation = new OnBoarding();
        itemHumanFormation.setBoardingName("Formación Humana");
        itemHumanFormation.setBoardDescription("Descripción");
        itemHumanFormation.setBoardImage("0B6xyiWpZ8iAFclJIMmh1Q25yYmc");
        itemHumanFormation.setBoardCircleColor("#ed6b03"); //#ed6b03  //#f88c01
        itemHumanFormation.setBoardingOrder(5);

        OnBoarding itemHumanValues = new OnBoarding();
        itemHumanValues.setBoardingName("Valores Humanos");
        itemHumanValues.setBoardDescription("Descripción");
        itemHumanValues.setBoardImage("0B6xyiWpZ8iAFUHRPMUZJSHRqekE");
        itemHumanValues.setBoardCircleColor("#d71760"); //#d71760
        itemHumanValues.setBoardingOrder(6);

        OnBoarding itemTransport = new OnBoarding();
        itemTransport.setBoardingName("Transporte");
        itemTransport.setBoardDescription("Descripción");
        itemTransport.setBoardImage("0B6xyiWpZ8iAFQnRpQWtXWmVGTVk");
        itemTransport.setBoardCircleColor("#ad0807"); //#ad0807   //#8f0403
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
