package com.mateuszjanczak.growhabits.server.service.impl;

import com.mateuszjanczak.growhabits.server.dto.TaskRequest;
import com.mateuszjanczak.growhabits.server.entity.Task.Task;
import com.mateuszjanczak.growhabits.server.repository.TaskRepository;
import com.mateuszjanczak.growhabits.server.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getSingleTask(String id) {
        return taskRepository.findById(id);
    }
}
