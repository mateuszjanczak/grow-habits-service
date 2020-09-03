package com.mateuszjanczak.growhabits.server.entity.Task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mateuszjanczak.growhabits.server.dto.OptionRequest;
import com.sun.istack.NotNull;

import javax.persistence.*;

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

    public Option() {
    }

    public Option(String name, double power) {
        this.name = name;
        this.power = power;
    }

    public Option(OptionRequest optionRequest) {
        this.name = optionRequest.getName();
        this.power = optionRequest.getPower();
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
