package com.mateuszjanczak.growhabits.server.entity.Task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mateuszjanczak.growhabits.server.dto.TaskRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "cooldown")
    private Long cooldown;

    @NotNull
    @Column(name = "lockTime")
    private Date lockTime;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Option> optionList;

    public Task() {
    }

    public Task(TaskRequest taskRequest) {
        this.title = taskRequest.getTitle();
        this.cooldown = taskRequest.getCooldown();
        this.lockTime = new Date();
        this.optionList = taskRequest.getOptionRequestList().stream().map(Option::new).collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }
}
