package com.wally.workhub.domain.task.service;

import com.wally.workhub.domain.task.domain.Task;
import com.wally.workhub.domain.task.domain.TaskManager;
import com.wally.workhub.domain.task.model.TaskCreate;
import com.wally.workhub.domain.task.model.TaskManagerCreate;
import com.wally.workhub.domain.task.repository.TaskManagerRepository;
import com.wally.workhub.domain.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskManagerRepository taskManagerRepository;

    public void createTask(TaskCreate taskCreate) {
        Task task = taskCreate.toEntity();

        taskRepository.save(task);

        createTaskManager(task.getId(), taskCreate.getManagers());
    }

    private void createTaskManager(Long taskId, List<TaskManagerCreate> managers) {
        List<TaskManager> taskManagers = new ArrayList<>();

        for (TaskManagerCreate taskManagerCreate : managers) {
            TaskManager taskManager = TaskManager.builder()
                    .taskId(taskId)
                    .chargeType(taskManagerCreate.getChargeType())
                    .userId(taskManagerCreate.getUserId())
                    .build();

            taskManagers.add(taskManager);
        }

        taskManagerRepository.saveAll(taskManagers);
    }
}
