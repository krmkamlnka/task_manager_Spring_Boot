package org.example.user_task_manager.Repositories;

import org.example.user_task_manager.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
