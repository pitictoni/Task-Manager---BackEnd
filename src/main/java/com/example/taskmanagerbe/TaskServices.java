package com.example.taskmanagerbe;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServices {
    private TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ArrayList<Task> addSampleTasks(){
        List<Task> mockTasks = new ArrayList<>();

        mockTasks.add(new Task("First task", 4));
        mockTasks.add(new Task("Second task", 1));
        mockTasks.add(new Task("Al treilea task", 2));

        return (ArrayList<Task>) taskRepository.saveAll(mockTasks);
    }

    public ArrayList<Task> getAllTasks() {
        return (ArrayList<Task>) taskRepository.findAll();
    }
}
