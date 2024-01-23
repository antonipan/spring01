package ru.antonio.spring03taskapplic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks () {
        return tasks;
    }

    public Task getTask (UUID id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst().orElse(null);
    }

    public Task addTask (Task task) {
        tasks.add(task);
        return task;
    }

    public List<Task> addAllTasks (List <Task> tasks) {
        this.tasks.addAll(tasks);
        return this.tasks;
    }

    public void removeTask (UUID id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }

    public Task updateTask (UUID id, Task newTask) {
        Task oldTask = getTask(id);
        if(oldTask != null) {
            oldTask.setName(newTask.getName());
            oldTask.setDescription(newTask.getDescription());
            oldTask.setStatus(newTask.getStatus());
            oldTask.setCompletionTime(newTask.getCompletionTime());
        }
        return oldTask;
    }
}
