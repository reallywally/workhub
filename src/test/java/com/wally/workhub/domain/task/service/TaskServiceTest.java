package com.wally.workhub.domain.task.service;

import com.wally.workhub.domain.task.TaskTestUtils;
import com.wally.workhub.domain.task.model.TaskCreate;
import com.wally.workhub.domain.task.repository.TaskManagerRepository;
import com.wally.workhub.domain.task.repository.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskManagerRepository taskManagerRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    @DisplayName("업무 요청 생성")
    void testCreateTask() {
        TaskCreate taskCreate = TaskTestUtils.generateTaskCreate();
        taskService.createTask(taskCreate);
    }
}