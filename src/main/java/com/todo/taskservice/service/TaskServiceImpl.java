package com.todo.taskservice.service;

import com.todo.taskservice.domain.Status;
import com.todo.taskservice.domain.Task;
import com.todo.taskservice.domain.TaskNotFoundException;
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
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if(Objects.isNull(optionalTask)){
            return null;
        }
        Task task = optionalTask.get();
        task.setPinned(pinned);
        return taskRepository.save(task);
    }

    @Override
    public void  deleteTask(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(Objects.nonNull(task)){
            taskRepository.deleteById(taskId);
        }
        else
            throw new TaskNotFoundException("404 : Task not found!");
    }
}
