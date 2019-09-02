package org.nishp.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nishp.springboot.pojo.Task;
import org.nishp.springboot.service.TaskManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskmController {

	private String loggedinUser;
	private String userRole;

	@Autowired
	private TaskManagementService services;

	private void setUserDetails() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			this.loggedinUser = ((UserDetails) principal).getUsername();
		} else {
			this.loggedinUser = principal.toString();
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			// String currentUserName = authentication.getAuthorities();
			this.userRole = "ROLE_USER";
			for (GrantedAuthority authority : authentication.getAuthorities()) {
				if (authority.getAuthority().equals("ROLE_ADMIN")) {
					this.userRole = "ROLE_ADMIN";
				}
			}
		}
	}

	@GetMapping("/ping")
	public String ping() {
		return "OK";
	}

	@GetMapping("/")
	public String homepage(HttpServletRequest req) {
		List<Task> tasks = services.getAllTasks();
		this.setUserDetails();
		// List<Task> tasks = services.findTasksByUsers(this.createdBy);
		// System.out.println(this.createdBy);
		// req.setAttribute("loggedIn", "true");
		req.setAttribute("loggedinUser", this.loggedinUser);
		req.setAttribute("userrole", this.userRole);
		req.setAttribute("tasks", tasks);
		return "index";
	}

	@GetMapping("/getAllTasks")
	public String getAllTasks() {
		return "getAllTasks";
	}

	@PostMapping(value = "/addTask")
	public String addTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest req) {
		// System.out.println(task.toString());
		this.setUserDetails();
		if (task.getTaskName() == null || task.getTaskScheduled() == null || task.getTaskDetails() == null) {
			System.out.println("Skip");
		} else {
			task.setCreatedBy(this.loggedinUser);
			services.addTask(task);
		}
		req.setAttribute("loggedinUser", this.loggedinUser);
		req.setAttribute("userrole", this.userRole);
		req.setAttribute("tasks", services.getAllTasks());
		return "index";

	}

	@GetMapping("/sitemap")
	public String getSitemap() {
		return "sitemap";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@PostMapping(value = "/someTasks", params = "getdetails")
	public String getTask(@ModelAttribute Task tempTask, BindingResult bindingResult, HttpServletRequest req) {
		Integer taskId = 0;
		taskId = tempTask.getTaskId();
		// System.out.println(taskId);
		if (services.taskExists(taskId)) {
			Task task = services.getTask(taskId);
			req.setAttribute("loadedtask", task);
		}
		this.setUserDetails();
		req.setAttribute("loggedinUser", this.loggedinUser);
		req.setAttribute("userrole", this.userRole);
		req.setAttribute("tasks", services.getAllTasks());
		return "index";
	}

	@PostMapping(value = "/someTasks", params = "deletetask")
	public String deleteTask(@ModelAttribute Task tempTask, BindingResult bindingResult, HttpServletRequest req) {
		if (tempTask.getTaskId() != null && services.taskExists(tempTask.getTaskId())) {
			services.removeTask(tempTask.getTaskId());
		}
		this.setUserDetails();
		req.setAttribute("loggedinUser", this.loggedinUser);
		req.setAttribute("userrole", this.userRole);
		req.setAttribute("tasks", services.getAllTasks());
		return "index";
	}

}
