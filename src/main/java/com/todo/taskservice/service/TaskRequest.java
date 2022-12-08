package com.todo.taskservice.service;

import com.todo.taskservice.domain.Status;

public class TaskRequest {
    private Long id;
    private Status status;
    private String description;
    private Long assigneeId;
    private Boolean pinned;

    public TaskRequest(Long id, Status status, String description, Long assigneeId, Boolean pinned) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.assigneeId = assigneeId;
        this.pinned = pinned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

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

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }
}
