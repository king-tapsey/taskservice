package com.todo.taskservice.service;

import com.todo.taskservice.domain.Status;
import com.todo.taskservice.domain.TaskStatus;
import com.todo.taskservice.persistence.TaskStatusRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskStatusServiceImpl implements TaskStatusService {
    TaskStatusRepository taskStatusRepository;

    public TaskStatusServiceImpl(TaskStatusRepository taskStatusRepository){
        this.taskStatusRepository = taskStatusRepository;
    }

    @Override
    public List<Status> getAllStatuses() {
        //return taskStatusRepository.findAll().stream().map(t -> t.getValue()).collect(Collectors.toList());
        return new ArrayList<>(Arrays.asList(Status.TO_DO, Status.IN_PROGRESS, Status.DONE));
    }
}
