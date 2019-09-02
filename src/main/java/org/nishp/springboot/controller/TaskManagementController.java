package org.nishp.springboot.controller;

import java.util.List;

import org.nishp.springboot.pojo.Task;
import org.nishp.springboot.service.TaskManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/task-management")
public class TaskManagementController {
	
	ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private TaskManagementService services;

/*	@GetMapping("/ping")
	public String ping() {
		return "OK";
	}*/


/*	
	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}*/

	@GetMapping(value = "/task/{taskId}")
	public ResponseEntity<?> getTask(@PathVariable("taskId") Integer taskId) {
		Task task = services.getTask(taskId);
		if (task == null) {
			return new ResponseEntity<>(("Task with id " + taskId + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}

	@GetMapping(value = "/tasks/")
	public ResponseEntity<?> getTasks() {
		List<Task> tasks = services.getAllTasks();
		if (tasks.isEmpty()) {
			return new ResponseEntity<>(("not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}

/*	@PutMapping(value = "/addTasks", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addTask(@RequestBody Task task) {
		System.out.println(task.toString());
		if (task.getTaskId() == null || services.getTask(task.getTaskId()) == null) {
//			System.out.println(task.toString());
			services.addTask(task);
			return new ResponseEntity<>(("New Task added"), HttpStatus.OK);
		} else {
			services.updateTask(task);
			return new ResponseEntity<>(("Task Updated"), HttpStatus.OK);
		}

	}*/

	@PostMapping(value = "/updateTasks/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateTask(@RequestBody Task task) {
		Integer taskId = task.getTaskId();
		Task tempTask = services.getTask(taskId);
		if (tempTask == null) {
			return new ResponseEntity<>(("Task does not exists"), HttpStatus.NOT_ACCEPTABLE);
		} else {
			services.updateTask(task);
			return new ResponseEntity<>(("Task Updated "), HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/deleteTasks/{taskId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> deleteTask(@PathVariable("taskId") Integer taskId) {
		Task task = services.getTask(taskId);
		if (task == null) {
			return new ResponseEntity<>(("Task with id " + taskId + " not found"), HttpStatus.NOT_FOUND);
		}
		services.removeTask(taskId);
		return new ResponseEntity<>(("Task with id " + taskId + " deleted"), HttpStatus.OK);
	}
}