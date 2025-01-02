package com.todolist.app.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(length = 12)
    private String userId;

    @Column(nullable = false, unique = true)
    private String username;
    @Column
    private String password;

    @Column(nullable = false, unique = true)
    @Email
    @Size(max = 255)
    private String email;


    @Column
    private String role;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private LocalDate created_At;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private LocalDate updated_At;

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;


    @PrePersist
    protected void onCreate() {
        this.userId = UUID.randomUUID().toString().substring(0, 12);
        this.created_At = LocalDate.now();
    }
}
