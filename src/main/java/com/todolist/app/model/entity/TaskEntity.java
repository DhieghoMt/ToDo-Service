package com.todolist.app.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String status;

    @Column
    private Date due_date;


    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private LocalDate created_At;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private LocalDate updated_At;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private UserEntity user;


    @PrePersist
    protected void onCreate() {
        this.taskId = UUID.randomUUID().toString().substring(0, 12);
        this.created_At = LocalDate.now();
    }
}
