package com.fpg.fpg.ws.pojo;

import com.orm.SugarRecord;

/**
 * Created by jhovany on 27/03/17.
 */

public class TypeCardWS extends SugarRecord {

    private String nameCardType;
    private Long remoteId;

    public TypeCardWS() {
    }

    public String getNameCardType() {
        return nameCardType;
    }

    public void setNameCardType(String nameCardType) {
        this.nameCardType = nameCardType;
    }

    public Long getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(Long remoteId) {
        this.remoteId = remoteId;
    }
}
