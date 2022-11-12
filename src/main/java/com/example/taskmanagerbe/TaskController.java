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

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        taskServices.deleteTaskById(id);
    }


    // http://localhost:8080/task/' + id
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id){
        return taskServices.getTaskById(id);
    }

    // http://localhost:8080/task/update?id=' + id + "&title" + title + "&priority" + priority
    @PutMapping(value = "/update",params = {"id", "title", "priority"})
    public void updateTask(@RequestParam("id") int id,  @RequestParam("title") String title, @RequestParam("priority") int priority){
        taskServices.updateTask(id, title,priority);
    }


    //http://localhost:8080/task/add?title=' + title + "&priority=" + priority
    @PostMapping(value = "/add", params = {"title", "priority"})
    public void addTask( @RequestParam("title") String title, @RequestParam("priority") int priority){
        taskServices.addTask(title,priority);
    }
}
