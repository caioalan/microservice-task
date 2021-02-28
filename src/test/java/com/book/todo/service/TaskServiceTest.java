package com.book.todo.service;

import com.book.todo.entity.Task;
import com.book.todo.mock.TaskMock;
import com.book.todo.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class TaskServiceTest {

    @Mock
    TaskRepository tasksRepository;

    private TaskService taskService;

    @BeforeEach
    public void setup() {

        taskService = new TaskService(tasksRepository);
        Pageable pageable = PageRequest.of(0, 5, Sort.by(
                Sort.Order.asc("name"),
                Sort.Order.desc("id")));
        Mockito.lenient().when(tasksRepository.findAll(pageable)).thenReturn(TaskMock.createTasks());
    }


    @Test
    @DisplayName("Should retun all tasks")
    public void getTasks_happypath() {

        Pageable pageable = PageRequest.of(0, 5, Sort.by(
                Sort.Order.asc("name"),
                Sort.Order.desc("id")));

        Page<Task> tasks = taskService.getTasks(pageable);

        assertEquals(tasks.getTotalPages(),1);
        assertEquals(tasks.getNumberOfElements(), 2);
        assertNotNull(tasks);
    }


    @Nested
    @DisplayName("Happy Tests")
    class happycases {

        @Test
        void justtest() {
            String name = "just testing";
            assertEquals(name, "just testing");
        }

        @Test
        void justtest1() {
            String name = "just testin";
            assertEquals(name, "just testin");
        }
    }


    @Nested
    @DisplayName("Unhappy Tests")
    class unhappycases {

        @Test
        void justtest() {
            String name = "just testing";
            assertEquals(name, "just testing");
        }

        @Test
        void justtest1() {
            String name = "just testincc";
            assertEquals(name, "just testincc");
        }
    }


}