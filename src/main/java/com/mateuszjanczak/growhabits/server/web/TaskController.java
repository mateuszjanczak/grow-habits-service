package com.mateuszjanczak.growhabits.server.web;

import com.mateuszjanczak.growhabits.server.dto.OptionRequest;
import com.mateuszjanczak.growhabits.server.dto.TaskRequest;
import com.mateuszjanczak.growhabits.server.entity.Task.Option;
import com.mateuszjanczak.growhabits.server.entity.Task.Task;
import com.mateuszjanczak.growhabits.server.repository.TaskRepository;
import com.mateuszjanczak.growhabits.server.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @CrossOrigin
    @GetMapping("test")
    public ResponseEntity<Void> test(){
        TaskRequest taskRequest = new TaskRequest("przykładowy tytuł", 60L, Arrays.asList(new OptionRequest("tak", 50), new OptionRequest("nie", 50)));
        taskService.saveTask(taskRequest);

        /*Task task = new Task("Example title", new Date(), Arrays.asList(new Option("Yes", 10), new Option("No", 10)));
        taskRepository.save(task);
        Task task2 = new Task("Example title2", new Date(System.currentTimeMillis() + 3600 * 1000), Arrays.asList(new Option("Yes", 10), new Option("No", 10)));
        taskRepository.save(task2);*/
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("tasks")
    public ResponseEntity<List<Task>> getTaskList() {
        List<Task> taskList = taskService.getTaskList();
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("task")
    public ResponseEntity<Task> saveTask(@RequestBody @Valid TaskRequest taskRequest) {
        Task task = taskService.saveTask(taskRequest);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
}
