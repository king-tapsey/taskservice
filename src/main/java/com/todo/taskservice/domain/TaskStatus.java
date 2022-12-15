package com.todo.taskservice.domain;

import javax.persistence.*;

@Entity
@Table(name="task_status")
@SequenceGenerator(name="sequence_generator",
        sequenceName = "sequence_generator",
        allocationSize = 1)

public class TaskStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private Status value;

    public TaskStatus(){

    }

    public TaskStatus(Long id, Status value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getValue() {
        return value;
    }

    public void setValue(Status value) {
        this.value = value;
    }

}
