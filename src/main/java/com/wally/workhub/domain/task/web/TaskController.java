package com.wally.workhub.domain.task.web;

import com.wally.workhub.domain.task.model.TaskCreate;
import com.wally.workhub.domain.task.model.TaskEdit;
import com.wally.workhub.domain.task.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public String getTasks() {
        return "업무 요청 목록 조회";
    }

    @GetMapping("/tasks/{taskId}")
    public String getTasksById(@PathVariable Long taskId) {
        return "업무 요청 단건 조회";
    }

    @PostMapping("/tasks")
    public String createTasks(@RequestBody @Valid TaskCreate taskCreate) {
        return "업무 요청 등록";
    }

    @PatchMapping("/tasks/{taskId}")
    public String updateTasks(@PathVariable Long taskId, @RequestBody TaskEdit TaskEdit) {
        return "업무 요청 수정";
    }

    @PostMapping("/tasks/{taskId}/approve")
    public String approveTasks(@PathVariable Long taskId, @RequestBody TaskEdit taskEdit) {
        return "업무 요청 승인";
    }

    @DeleteMapping("/tasks/{taskId}")
    public String deleteTasks(@PathVariable Long taskId) {
        return "업무 요청 삭제";
    }
}
