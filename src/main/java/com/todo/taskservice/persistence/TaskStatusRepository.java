package com.todo.taskservice.persistence;

import com.todo.taskservice.domain.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {

}
