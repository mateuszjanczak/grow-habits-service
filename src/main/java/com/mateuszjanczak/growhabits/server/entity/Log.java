package com.mateuszjanczak.growhabits.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mateuszjanczak.growhabits.server.entity.Task.Task;
import com.mateuszjanczak.growhabits.server.entity.Task.Option;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    @ManyToOne
    @JoinColumn(name = "task_option_id")
    @JsonIgnore
    private Option option;

    @NotNull
    @Column(name = "date")
    private Date date;

    public Log() {
    }

    public Log(Task task, Option option, Date date) {
        this.task = task;
        this.option = option;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Option getTaskOption() {
        return option;
    }

    public void setTaskOption(Option option) {
        this.option = option;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
