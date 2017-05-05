package com.fpg.fpg.models;

import com.orm.SugarRecord;

/**
 * Created by jhovany on 27/03/17.
 */

public class OnBoarding extends SugarRecord {

    private String BoardingName;
    private String BoardDescription;
    private String BoardImage;
    private String BoardCircleColor;
    private Long BoardingOrder;

    public OnBoarding() {
    }

    public String getBoardingName() {
        return BoardingName;
    }

    public void setBoardingName(String boardingName) {
        BoardingName = boardingName;
    }

    public String getBoardDescription() {
        return BoardDescription;
    }

    public void setBoardDescription(String boardDescription) {
        BoardDescription = boardDescription;
    }

    public String getBoardImage() {
        return BoardImage;
    }

    public void setBoardImage(String boardImage) {
        BoardImage = boardImage;
    }

    public String getBoardCircleColor() {
        return BoardCircleColor;
    }

    public void setBoardCircleColor(String boardCircleColor) {
        BoardCircleColor = boardCircleColor;
    }

    public Long getBoardingOrder() {
        return BoardingOrder;
    }

    public void setBoardingOrder(Long boardingOrder) {
        BoardingOrder = boardingOrder;
    }
}
