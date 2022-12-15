package com.todo.taskservice.service;

import com.todo.taskservice.domain.Status;
import com.todo.taskservice.domain.TaskStatus;

import java.util.List;

public interface TaskStatusService {
    List<Status> getAllStatuses();
}
