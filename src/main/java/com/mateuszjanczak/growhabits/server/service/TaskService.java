package com.mateuszjanczak.growhabits.server.service;

import com.mateuszjanczak.growhabits.server.dto.TaskRequest;
import com.mateuszjanczak.growhabits.server.entity.Task.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getTaskList();
    Task saveTask(Task task);
    Optional<Task> getSingleTask(String id);
}
