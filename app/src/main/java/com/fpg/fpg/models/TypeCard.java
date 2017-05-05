package com.fpg.fpg.models;

import com.orm.SugarRecord;

/**
 * Created by jhovany on 27/03/17.
 */

public class TypeCard extends SugarRecord {

    private Long id;
    private Long remoteId;
    private String nameCardType;

    public TypeCard() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(Long remoteId) {
        this.remoteId = remoteId;
    }

    public String getNameCardType() {
        return nameCardType;
    }

    public void setNameCardType(String nameCardType) {
        this.nameCardType = nameCardType;
    }
}
