package boot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import boot.model.Task;
import boot.service.TaskService;

@RestController
public class SampleRestController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/hello")
	
	public String hello(){
	return "Hellow Word";
	}
	/*
	@GetMapping("/all-tasks")
	public String allTasks(){
		
		return taskService.findAll().toString();
		
	}
	@GetMapping("/save-task")
	public String saveTask(@RequestParam String name, @RequestParam String description){
		Task task=new Task(name,description,new Date(),false);
		taskService.save(task);
		return "Task saved!";
	}
	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam int id){
		taskService.delete(id);
		return "Task deleted!";
	}
	*/
}
