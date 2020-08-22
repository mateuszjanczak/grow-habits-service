package com.mateuszjanczak.growhabits.server.repository;

import com.mateuszjanczak.growhabits.server.entity.Task.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskOptionRepository extends JpaRepository<Option, String> {
}
