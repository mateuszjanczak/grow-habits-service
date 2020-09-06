package com.mateuszjanczak.growhabits.server.service.impl;

import com.mateuszjanczak.growhabits.server.dto.OptionResponse;
import com.mateuszjanczak.growhabits.server.dto.RollRequest;
import com.mateuszjanczak.growhabits.server.dto.RollResponse;
import com.mateuszjanczak.growhabits.server.entity.Task.Option;
import com.mateuszjanczak.growhabits.server.entity.Task.Task;
import com.mateuszjanczak.growhabits.server.exception.TaskNotFoundException;
import com.mateuszjanczak.growhabits.server.service.RollService;
import com.mateuszjanczak.growhabits.server.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RollServiceImpl implements RollService {

    private final TaskService taskService;

    public RollServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public RollResponse roll(RollRequest rollRequest) {

        String id = rollRequest.getId();
        Task task = taskService.getSingleTask(id).orElseThrow(() -> new TaskNotFoundException(id));

        double randomNumber = getRandomNumber();

        OptionResponse winOption = null;
        double acc = 0;
        int segment = 0;

        for (Option option : task.getOptionList()) {
            double power = option.getPower();
            segment++;

            if(randomNumber < power + acc) {
                winOption = new OptionResponse(option, segment);
                break;
            }

            acc += power;
        }

        task.setLockTime(new Date( System.currentTimeMillis() + task.getCooldown() * 1000));
        taskService.saveTask(task);

        return new RollResponse(task.getId(), winOption, task.getLockTime());
    }

    private double getRandomNumber() {
        return ThreadLocalRandom.current().nextDouble(0, 100);
    }
}
