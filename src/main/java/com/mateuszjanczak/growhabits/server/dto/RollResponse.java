package com.mateuszjanczak.growhabits.server.dto;

import java.util.Date;

public class RollResponse {
    private String id;
    private OptionResponse option;
    private Date lockTime;

    public RollResponse(String id, OptionResponse option, Date lockTime) {
        this.id = id;
        this.option = option;
        this.lockTime = lockTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OptionResponse getOption() {
        return option;
    }

    public void setOption(OptionResponse option) {
        this.option = option;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }
}
