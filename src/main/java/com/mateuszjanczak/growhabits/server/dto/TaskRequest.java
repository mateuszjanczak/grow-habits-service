package com.mateuszjanczak.growhabits.server.dto;

import javax.validation.constraints.NotNull;

import java.util.List;

public class TaskRequest {

    @NotNull(message = "Title cannot be null")
    private String title;

    @NotNull(message = "Cooldown cannot be null")
    private Long cooldown;

    @NotNull(message = "Option list cannot be null")
    private List<OptionRequest> optionRequestList;

    public TaskRequest() {

    }

    public TaskRequest(String title, Long cooldown, List<OptionRequest> optionRequestList) {
        this.title = title;
        this.cooldown = cooldown;
        this.optionRequestList = optionRequestList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCooldown() {
        return cooldown;
    }

    public void setCooldown(Long cooldown) {
        this.cooldown = cooldown;
    }

    public List<OptionRequest> getOptionRequestList() {
        return optionRequestList;
    }

    public void setOptionRequestList(List<OptionRequest> optionRequestList) {
        this.optionRequestList = optionRequestList;
    }
}
