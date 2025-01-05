package com.todolist.app.repository;

import com.todolist.app.model.dto.TaskDto;
import com.todolist.app.model.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, String> {

    @Query(value = """
            SELECT * FROM tasks t where t.user_id = :userId
            """, nativeQuery = true)
    List<TaskEntity> getTasksByUserId(@Param("userId") String userId);

}
