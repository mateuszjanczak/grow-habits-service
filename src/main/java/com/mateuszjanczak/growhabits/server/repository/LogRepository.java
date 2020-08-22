package com.mateuszjanczak.growhabits.server.repository;

import com.mateuszjanczak.growhabits.server.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, String> {
}
