package com.wally.workhub.domain.task.service;

import com.wally.workhub.domain.task.model.dto.TaskCreate;
import com.wally.workhub.domain.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskRequestService {
    private final TaskRepository taskRepository;

    public void createTask(TaskCreate taskCreate) {

    }
}
