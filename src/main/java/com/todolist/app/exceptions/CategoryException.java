package com.todolist.app.exceptions;

import lombok.Getter;

@Getter
public class CategoryException extends RuntimeException {

    private final int httpStatusCode;
    private final Object data;

    public CategoryException(String message, int httpStatusCode, Object data) {
        super(message);
        this.httpStatusCode = httpStatusCode;
        this.data = data;
    }
}
