package com.todolist.app.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @Column(length = 12)
    private String categoryId;

    @Column
    private String nameCategory;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private List<TaskEntity> tasks;


    @PrePersist
    protected void onCreate() {
        this.categoryId = UUID.randomUUID().toString().substring(0, 12);
    }

}
