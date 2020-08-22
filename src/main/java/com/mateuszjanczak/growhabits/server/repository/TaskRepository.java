package com.mateuszjanczak.growhabits.server.repository;

import com.mateuszjanczak.growhabits.server.entity.Task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
}
