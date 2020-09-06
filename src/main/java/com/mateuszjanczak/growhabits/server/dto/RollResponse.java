package com.mateuszjanczak.growhabits.server.dto;

import com.mateuszjanczak.growhabits.server.entity.Task.Option;

import java.util.Date;

public class RollResponse {
    private String id;
    private Option option;
    private Date lockTime;

    public RollResponse(String id, Option option, Date lockTime) {
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

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }
}
