package com.todo.taskservice.service;

import com.todo.taskservice.domain.Status;
import com.todo.taskservice.domain.Task;
import com.todo.taskservice.domain.exception.TaskNotFoundException;
import com.todo.taskservice.persistence.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTasksByAssigneeId(Long assigneeId) {
        return taskRepository.getTasksByAssigneeId(assigneeId);
    }

    @Override
    public List<Task> getTasksByPinnedAndAssigneeId(Boolean pinned, Long assigneeId) {
        return taskRepository.getTasksByPinnedAndAndAssigneeId(pinned, assigneeId);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(TaskCreateRequest taskCreateRequest) {
        Task task = new Task();
        task.setAssigneeId(taskCreateRequest.getAssigneeId());
        task.setDescription(taskCreateRequest.getDescription());
        task.setStatus(Status.TO_DO);
        task.setPinned(false);

        return taskRepository.save(task);
    }

    @Override
    public Task updateTaskPinnedStatus(Long taskId, Boolean pinned) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.setPinned(pinned);
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long taskId, TaskRequest taskRequest) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.setDescription(taskRequest.getDescription());
        task.setPinned(taskRequest.getPinned());
        task.setStatus(taskRequest.getStatus());
        task.setAssigneeId(taskRequest.getAssigneeId());

        return taskRepository.save(task);
    }

    @Override
    public void  deleteTask(Long taskId) {
        taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        taskRepository.deleteById(taskId);
    }
}
