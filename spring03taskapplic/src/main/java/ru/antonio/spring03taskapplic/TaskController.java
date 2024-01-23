package ru.antonio.spring03taskapplic;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTask () {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getById (@PathVariable UUID id) {
        return taskService.getTask(id);
    }

    @PostMapping
    public Task addById (@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @PostMapping("/tasks")
    public List<Task> addTasks(@RequestBody List <Task> taskes) {
        return taskService.addAllTasks(taskes);
    }

    @PutMapping("/{id}")
    public Task updateTask (@PathVariable UUID id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask (@PathVariable UUID id) {
        taskService.removeTask(id);
    }
}
