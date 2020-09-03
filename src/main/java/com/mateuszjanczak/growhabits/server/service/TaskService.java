package com.mateuszjanczak.growhabits.server.service;

import com.mateuszjanczak.growhabits.server.dto.TaskRequest;
import com.mateuszjanczak.growhabits.server.entity.Task.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTaskList();
    Task saveTask(TaskRequest taskRequest);
}
