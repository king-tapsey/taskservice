package com.todo.taskservice.api;

import com.todo.taskservice.domain.Task;
import com.todo.taskservice.service.TaskCreateRequest;
import com.todo.taskservice.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/tasks")
public class TaskRestController {
    private final TaskService taskService;

    public TaskRestController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{assigneeId}")
    public List<Task> getTasksByAssigneeId(@PathVariable Long assigneeId){
        return taskService.getTasksByAssigneeId(assigneeId);
    }

    @GetMapping("/pinned/{assigneeId}")
    public List<Task> getPinnedTasks(@PathVariable Long assigneeId){
        return taskService.getTasksByPinnedAndAssigneeId(true, assigneeId);
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

    @DeleteMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable Long taskId){
        return taskService.deleteTask(taskId);
    }

    @PostMapping("/create")
    public TaskDto createTask(@RequestBody TaskCreateRequest taskCreateRequest){
        Task task = taskService.createTask(taskCreateRequest);
        return TaskDto.of(task);
    }


}