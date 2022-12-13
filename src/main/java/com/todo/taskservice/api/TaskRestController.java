package com.todo.taskservice.api;

import com.todo.taskservice.domain.Task;
import com.todo.taskservice.service.TaskCreateRequest;
import com.todo.taskservice.service.TaskRequest;
import com.todo.taskservice.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/tasks")
public class TaskRestController {
    private final TaskService taskService;

    public TaskRestController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public TaskDto createTask(@RequestBody TaskCreateRequest taskCreateRequest){
        Task task = taskService.createTask(taskCreateRequest);
        return TaskDto.of(task);
    }

    @PutMapping("/update/{taskId}")
    public TaskDto updateTask(@PathVariable Long taskId, TaskRequest taskRequest){
        Task task = taskService.updateTask(taskId, taskRequest);
        return TaskDto.of(task);
    }

    @DeleteMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable Long taskId){
        return taskService.deleteTask(taskId);
    }
    @GetMapping
    public Page<Task> getAllTasks(@PageableDefault Pageable pageable){
        List<Task> tasks = taskService.getAllTasks();
        return new PageImpl<>(tasks, pageable, tasks.size());
    }

    @GetMapping("/{assigneeId}")
    public Page<Task> getTasksByAssigneeId(@PageableDefault Pageable pageable, @PathVariable Long assigneeId){
        List<Task> tasks = taskService.getTasksByAssigneeId(assigneeId);
        return new PageImpl<>(tasks, pageable, tasks.size());
    }

    @GetMapping("/task/{taskId}")
    public TaskDto getTaskById(@PathVariable Long taskId){
        Task task = taskService.getTaskById(taskId);
        return TaskDto.of(task);
    }
    @PutMapping("/pin/{taskId}")
    public TaskDto pinTask(@PathVariable Long taskId){
        Task task = taskService.updateTaskPinnedStatus(taskId, true);
        return TaskDto.of(task);
    }
    @PutMapping("/unpin/{taskId}")
    public TaskDto unPinTask(@PathVariable Long taskId){
        Task task = taskService.updateTaskPinnedStatus(taskId,false);
        return TaskDto.of(task);
    }

    @GetMapping("/pinned/{assigneeId}")
    public Page<Task> getPinnedTasks(@PageableDefault Pageable pageable, @PathVariable Long assigneeId){
        List<Task> pinnedTasks = taskService.getTasksByPinnedAndAssigneeId(true, assigneeId);
        return new PageImpl<>(pinnedTasks, pageable, pinnedTasks.size());
    }

}