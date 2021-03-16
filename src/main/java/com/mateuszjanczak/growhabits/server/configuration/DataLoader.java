package com.mateuszjanczak.growhabits.server.configuration;

import com.mateuszjanczak.growhabits.server.dto.OptionRequest;
import com.mateuszjanczak.growhabits.server.dto.TaskRequest;
import com.mateuszjanczak.growhabits.server.entity.Task.Task;
import com.mateuszjanczak.growhabits.server.service.TaskService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    final TaskService taskService;

    public DataLoader(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void run(ApplicationArguments args) {
        createTasks();
    }

    private void createTasks() {
        TaskRequest taskRequest1 = new TaskRequest("Codzienne jedzenie fastfoodu", 86400L, Arrays.asList(new OptionRequest("Pewnie", 25, "#2af068"), new OptionRequest("Nie dzisiaj :)", 75, "#fb2331")));
        taskService.saveTask(new Task(taskRequest1));

        TaskRequest taskRequest2 = new TaskRequest("Pompki", 0L, Arrays.asList(new OptionRequest("5", 20, "#20b68d"), new OptionRequest("10", 20, "#e55364"), new OptionRequest("15", 20, "#ea9854"), new OptionRequest("20", 20, "#076de1"), new OptionRequest("25", 20, "#c7cdef")));
        taskService.saveTask(new Task(taskRequest2));
    }
}
