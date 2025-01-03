package com.todolist.app.util;

import org.springframework.stereotype.Component;

@Component
public class Constants {

    public static final String SUCCESS = "SUCCESS";

    //Task Messages
    public static final String TASK_NOT_FOUND = "No task found";
    public static final String TASK_FAILED_CREATE = "Failed to create task";
    public static final String TASK_FAILED_UPDATE = "Failed to update task";


    //User Messages
    public static final String USER_NOT_FOUND = "No user found";
    public static final String USER_FAILED_CREATE = "Failed to create user";
    public static final String USER_FAILED_UPDATE = "Failed to update user";

}
