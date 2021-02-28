package com.book.todo.integration;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.book.todo.TodoApplication;

import io.restassured.RestAssured;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@SpringBootTest(classes = {TodoApplication.class},  webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class TasksControllerIntegrationTest {

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.port = 8080;
    }

    @Test
    public void givenUrl_whenSuccessOnGetsResponseAndJsonHasRequiredKV_thenCorrect() {
        get("/api/todo/tasks").then().statusCode(200);
    }

    @Test
    public void givenUrl_whenSuccessOnGetsResponseAndJsonHasOneTask_thenCorrect() {
        get("/api/todo/task/1").then().statusCode(200)
                .assertThat().body("name",
                equalTo("name1"),"description",
                equalTo("Primeira tarefa"));
    }

    @Test
    public void givenUrl_whenSuccessOnGetsResponseAndJsonHasTwoTask_thenCorrect() {
        get("/api/todo/task/2").then().statusCode(200)
                .assertThat().body("name",
                equalTo("name2"),"description",
                equalTo("Segunda tarefa"));
    }
}