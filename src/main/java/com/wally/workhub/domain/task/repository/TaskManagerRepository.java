package com.wally.workhub.domain.task.repository;

import com.wally.workhub.domain.task.domain.TaskManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskManagerRepository extends JpaRepository<TaskManager, Long> {
}
