package com.todo.taskservice.service;

import com.todo.taskservice.domain.Status;
import com.todo.taskservice.domain.Task;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long taskId);
    List<Task> getTasksByAssigneeId(Long assigneeId);
    List<Task> getTasksByPinnedAndAssigneeId(Boolean pinned, Long assigneeId);
    List<Task> getTasksByStatus(Pageable pageable, Status status);
    Task createTask(TaskCreateRequest taskCreateRequest);
    Task updateTaskPinnedStatus(Long taskId, Boolean pinned);
    Task updateTask(Long taskId, TaskRequest taskRequest);

    String deleteTask(Long taskId);
}
