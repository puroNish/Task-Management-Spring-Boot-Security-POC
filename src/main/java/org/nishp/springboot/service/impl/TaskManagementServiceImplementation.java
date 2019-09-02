package org.nishp.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.nishp.springboot.pojo.Task;
import org.nishp.springboot.repo.TaskRepository;
import org.nishp.springboot.service.TaskManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskManagementServiceImplementation implements TaskManagementService {

	@Autowired
	private TaskRepository taskRepo;

	@Override
	public boolean taskExists(Integer taskId) {
		// TODO Auto-generated method stub
		if (taskRepo.existsById(taskId)) {
			return true;
		}
		return false;
	}

	@Override
	public Task getTask(Integer taskId) {
		// TODO Auto-generated method stub
		if (taskRepo.existsById(taskId)) {
			return taskRepo.findById(taskId).get();
		}
		return null;
	}

	@Override
	public void addTask(Task task) {
		// TODO Auto-generated method stub
		// System.out.println("adding "+ task.toString());
		taskRepo.save(task);
	}

	@Override
	public void removeTask(Integer id) {
		// TODO Auto-generated method stub
		taskRepo.deleteById(id);
	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepo.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		List<Task> tasks = new ArrayList<Task>();
		taskRepo.findAll().forEach(tasks::add);
		return tasks;
	}

}
