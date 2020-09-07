package com.mateuszjanczak.growhabits.server.entity.Task;

import com.mateuszjanczak.growhabits.server.dto.OptionRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "power")
    private double power;

    @NotNull
    @Column(name = "color")
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Option() {
    }

    public Option(String name, double power, String color) {
        this.name = name;
        this.power = power;
        this.color = color;
    }

    public Option(OptionRequest optionRequest) {
        this.name = optionRequest.getName();
        this.power = optionRequest.getPower();
        this.color = optionRequest.getColor();
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
}
