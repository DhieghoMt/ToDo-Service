package com.todolist.app.util;

import org.springframework.stereotype.Component;

@Component
public class Constants {

    public static final String SUCCESS = "SUCCESS";

    //Task Messages
    public static final String TASK_NOT_FOUND = "No task found";
    public static final String TASK_FAILED_CREATE = "Failed to create task";
    public static final String TASK_FAILED_UPDATE = "Failed to update task";
    public static final String TASK_CATEGORY_ALREADY_ASIGNNED = "Task already has this category assigned";


    //User Messages
    public static final String USER_NOT_FOUND = "No user found";
    public static final String USER_FAILED_CREATE = "Failed to create user";
    public static final String USER_FAILED_UPDATE = "Failed to update user";

    //Category Messages
    public static final String CATEGORY_NOT_FOUND = "No category found";
    public static final String CATEGORY_FAILED_CREATE = "Failed to create category";
    public static final String CATEGORY_FAILED_UPDATE = "Failed to update category";


}
