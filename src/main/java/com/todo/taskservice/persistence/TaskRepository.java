package com.todo.taskservice.persistence;

import com.todo.taskservice.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> getTasksByPinnedAndAndAssigneeId(Boolean isPinned, Long assigneeId);
    List<Task> getTasksByAssigneeId(Long assigneeId);
}
