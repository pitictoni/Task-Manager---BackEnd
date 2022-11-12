package com.example.taskmanagerbe;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class TaskController {
    private TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @PostMapping("/addTestTasks")
    public ArrayList<Task> addTestTasks(){
        return taskServices.addSampleTasks();
    }

    @GetMapping("/all")
    public ArrayList<Task> getAllTasks(){
        return taskServices.getAllTasks();
    }
}
