package com.book.todo.service;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.book.todo.dto.TaskDto;
import com.book.todo.entity.Task;
import com.book.todo.repository.TaskRepository;

@Slf4j
@Service
public class TaskService {

    private TaskRepository tasksRepository;

    public TaskService(TaskRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public Page<Task> getTasks(Pageable pageable) {
        return tasksRepository.findAll(pageable);
    }

    public Task getTask(long taskId) {
        Optional<Task> task = tasksRepository.findById(taskId);
        return task.get();
    }

    public Task saveTask(TaskDto taskDto) {
    	ModelMapper modelMapper = new ModelMapper();
        Task task = modelMapper.map(taskDto, Task.class);
        
        return tasksRepository.save(task);
    }
}