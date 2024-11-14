package org.example.user_task_manager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.user_task_manager.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
