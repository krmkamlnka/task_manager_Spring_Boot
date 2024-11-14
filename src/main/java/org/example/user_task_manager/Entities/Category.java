package org.example.user_task_manager.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Category {
    @Id
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Task> tasks;

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
    public Set<Task> getTasks() {
        return tasks;
    }

    public void setName(String name) {
        this.name =name;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
