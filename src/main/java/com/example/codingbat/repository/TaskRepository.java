package com.example.codingbat.repository;

import com.example.codingbat.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    boolean existsByName(String name);
}
