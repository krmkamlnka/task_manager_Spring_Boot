package org.example.user_task_manager.Controllers;

import org.example.user_task_manager.Entities.Task;
import org.example.user_task_manager.Repositories.TaskRepository;
import org.example.user_task_manager.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/tasks")
    public String listTasks(Model model, Authentication authentication) {
        String username = authentication.getName();
        List<Task> tasks = taskRepository.findByUserUsername(username);
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/tasks/new")
    public String showCreateTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "create_task";
    }

    @PostMapping("/tasks")
    public String createTask(Task task, Authentication authentication) {
        String username = authentication.getName();
        task.setUser(userRepository.findByUsername(username));
        taskRepository.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/tasks";
    }
}

