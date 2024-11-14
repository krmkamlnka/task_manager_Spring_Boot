package org.example.user_task_manager.Repositories;

import org.example.user_task_manager.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.user.username = :username")
    List<Task> findByUserUsername(@Param("username") String username);


}
