package com.todo.taskservice.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="task")
@SequenceGenerator(name="sequence_generator",
        sequenceName = "sequence_generator",
        allocationSize = 1)
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private Status status;

    @Column(name = "description")
    private String description;

    @Column(name = "assignee_id")
    private Long assigneeId;
    @Column(name = "pinned")
    private Boolean pinned;

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }


    public Task() {
    }

    public Task(Long id, Status status, String description, Long assigneeId, Boolean pinned) {
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
}

