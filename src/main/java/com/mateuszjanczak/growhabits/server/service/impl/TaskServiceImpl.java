package com.mateuszjanczak.growhabits.server.service.impl;

import com.mateuszjanczak.growhabits.server.dto.TaskRequest;
import com.mateuszjanczak.growhabits.server.entity.Task.Task;
import com.mateuszjanczak.growhabits.server.repository.TaskRepository;
import com.mateuszjanczak.growhabits.server.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTaskList() {
        return taskRepository.findAll();
    }

    @Override
    public Task saveTask(TaskRequest taskRequest) {
        Task task = new Task(taskRequest);
        return taskRepository.save(task);
        //return taskRepository.save(task);
    }
}
