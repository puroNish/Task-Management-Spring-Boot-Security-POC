package org.nishp.springboot.service;

import java.util.List;

import org.nishp.springboot.pojo.Task;

public interface TaskManagementService {

	public boolean taskExists(Integer taskId);

	public Task getTask(Integer taskId);

	public void addTask(Task task);

	public void removeTask(Integer id);

	public Task updateTask(Task task);
	
	public List<Task> getAllTasks();

}
