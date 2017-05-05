package com.fpg.fpg.ws.pojo;

import com.orm.SugarRecord;

/**
 * Created by jhovany on 27/03/17.
 */

public class DateNewsWS extends SugarRecord {

    private String startDay;
    private String finishDay;
    private String month;
    private String year;
    private Long remoteId;

    public DateNewsWS() {
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getFinishDay() {
        return finishDay;
    }

    public void setFinishDay(String finishDay) {
        this.finishDay = finishDay;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Long getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(Long remoteId) {
        this.remoteId = remoteId;
    }
}
