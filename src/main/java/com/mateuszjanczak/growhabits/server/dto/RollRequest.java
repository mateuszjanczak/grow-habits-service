package com.mateuszjanczak.growhabits.server.dto;


import javax.validation.constraints.NotNull;

public class RollRequest {

    @NotNull
    private String id;

    public RollRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
