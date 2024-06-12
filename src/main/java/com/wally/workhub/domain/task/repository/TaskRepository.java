package com.wally.workhub.domain.task.repository;

import com.wally.workhub.domain.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
