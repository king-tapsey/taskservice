package com.todo.taskservice.service;

import com.todo.taskservice.domain.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    List<Task> getTasksByAssigneeId(Long assigneeId);
    List<Task> getTasksByPinnedAndAssigneeId(Boolean pinned, Long assigneeId);
    Task createTask(TaskCreateRequest taskCreateRequest);
    Task updateTaskPinnedStatus(Long taskId, Boolean pinned);

    void deleteTask(Long taskId);
}
