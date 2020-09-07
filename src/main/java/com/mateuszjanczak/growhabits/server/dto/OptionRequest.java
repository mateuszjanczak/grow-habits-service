package com.mateuszjanczak.growhabits.server.dto;

import javax.validation.constraints.NotNull;

public class OptionRequest {

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Power cannot be null")
    private double power;

    @NotNull(message = "Color cannot be null")
    private String color;

    public OptionRequest() {
    }

    public OptionRequest(String name, double power, String color) {
        this.name = name;
        this.power = power;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
}
