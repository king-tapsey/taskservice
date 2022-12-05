package com.todo.taskservice.service;

import com.todo.taskservice.domain.Status;

public class TaskCreateRequest {
    private String description;
    private Long assigneeId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

}
