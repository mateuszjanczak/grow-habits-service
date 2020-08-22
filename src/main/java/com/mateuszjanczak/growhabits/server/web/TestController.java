package com.mateuszjanczak.growhabits.server.web;

import com.mateuszjanczak.growhabits.server.entity.Task.Option;
import com.mateuszjanczak.growhabits.server.entity.Task.Task;
import com.mateuszjanczak.growhabits.server.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TaskRepository taskRepository;

    @CrossOrigin
    @GetMapping("/test")
    public ResponseEntity<Void> test(){
        Task task = new Task("Example title", 10, Arrays.asList(new Option("Yes", 10), new Option("No", 10)));
        taskRepository.save(task);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
