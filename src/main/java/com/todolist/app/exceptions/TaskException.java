package com.todolist.app.exceptions;

import lombok.Getter;

@Getter
public class TaskException extends RuntimeException {

    private final int httpStatusCode;
    private final Object data;

    public TaskException(String message, int httpStatusCode, Object data) {
        super(message);
        this.httpStatusCode = httpStatusCode;
        this.data = data;
    }


}
