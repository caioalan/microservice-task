package com.book.todo.uri;

import org.springframework.hateoas.server.EntityLinks;
import org.springframework.stereotype.Component;

@Component
public class TaskUri {

	private final EntityLinks entityLinks;

    public static final String TASKS = "/tasks";
    public static final String TASK = "/task/{id}";
    public static final String CREATE_TASK = "/task";

    public TaskUri(EntityLinks entityLinks) {
        this.entityLinks = entityLinks;
    }

}
