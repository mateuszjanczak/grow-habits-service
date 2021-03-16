package com.mateuszjanczak.growhabits.server.web;

import com.mateuszjanczak.growhabits.server.dto.TaskRequest;
import com.mateuszjanczak.growhabits.server.entity.Task.Task;
import com.mateuszjanczak.growhabits.server.exception.TaskNotFoundException;
import com.mateuszjanczak.growhabits.server.repository.TaskRepository;
import com.mateuszjanczak.growhabits.server.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTaskList() {
        List<Task> taskList = taskService.getTaskList();
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> saveTask(@RequestBody @Valid TaskRequest taskRequest) {
        Task task = taskService.saveTask(new Task(taskRequest));
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<Task> getSingleTask(@PathVariable String id) {
        Task task = taskService.getSingleTask(id).orElseThrow(() -> new TaskNotFoundException(id));
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
}
