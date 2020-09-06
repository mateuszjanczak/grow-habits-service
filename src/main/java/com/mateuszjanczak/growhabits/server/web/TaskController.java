package com.mateuszjanczak.growhabits.server.web;

import com.mateuszjanczak.growhabits.server.dto.OptionRequest;
import com.mateuszjanczak.growhabits.server.dto.TaskRequest;
import com.mateuszjanczak.growhabits.server.entity.Task.Option;
import com.mateuszjanczak.growhabits.server.entity.Task.Task;
import com.mateuszjanczak.growhabits.server.exception.TaskNotFoundException;
import com.mateuszjanczak.growhabits.server.repository.TaskRepository;
import com.mateuszjanczak.growhabits.server.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;
    private final TaskRepository taskRepository;

    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @CrossOrigin
    @GetMapping("/test")
    public ResponseEntity<Void> test(){
        TaskRequest taskRequest = new TaskRequest("przykładowy tytuł", 60L, Arrays.asList(new OptionRequest("tak", 50), new OptionRequest("nie", 50)));
        taskService.saveTask(new Task(taskRequest));

        /*Task task = new Task("Example title", new Date(), Arrays.asList(new Option("Yes", 10), new Option("No", 10)));
        taskRepository.save(task);*/

        Task task = new Task();
        task.setTitle("przykładowy tytuł z cooldownem 1h");
        task.setLockTime(new Date(System.currentTimeMillis() + 3600 * 1000));
        task.setCooldown(60L);
        task.setOptionList(Arrays.asList(new Option("Yes", 10), new Option("No", 10)));
        taskRepository.save(task);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTaskList() {
        List<Task> taskList = taskService.getTaskList();
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/tasks")
    public ResponseEntity<Task> saveTask(@RequestBody @Valid TaskRequest taskRequest) {
        Task task = taskService.saveTask(new Task(taskRequest));
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<Task> getSingleTask(@PathVariable String id) {
        Task task = taskService.getSingleTask(id).orElseThrow(() -> new TaskNotFoundException(id));
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
}
