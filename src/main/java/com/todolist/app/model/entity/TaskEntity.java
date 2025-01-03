package com.todolist.app.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @Column(length = 12)
    private String taskId;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String description;

    @Column(length = 20, nullable = false)
    private String status;

    @Column(length = 20, nullable = false)
    private LocalDate due_date;


    @Column(length = 20, nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate created_At;

    @Column(length = 20)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime updated_At;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;


    @PrePersist
    protected void onCreate() {
        this.taskId = UUID.randomUUID().toString().substring(0, 12);
        this.created_At = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_At = LocalDateTime.now();
    }

    @PreRemove
    protected void onDelete() {
        this.updated_At = LocalDateTime.now();
    }


}
