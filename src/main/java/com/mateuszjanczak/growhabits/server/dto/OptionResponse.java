package com.mateuszjanczak.growhabits.server.dto;

import com.mateuszjanczak.growhabits.server.entity.Task.Option;

public class OptionResponse {

    private String id;
    private String name;
    private double power;
    private int segment;

    public OptionResponse() {
    }

    public OptionResponse(String id, String name, double power, int segment) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.segment = segment;
    }

    public OptionResponse(Option option, int segment) {
        this.id = option.getId();
        this.name = option.getName();
        this.power = option.getPower();
        this.segment = segment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public int getSegment() {
        return segment;
    }

    public void setSegment(int segment) {
        this.segment = segment;
    }
}
