package com.todolist.app.model.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private String userId;
    private String username;
    private String password;
    private String email;
    private String role;
    private LocalDate created_At;
    private LocalDate updated_At;


}
