package org.nishp;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.nishp.springboot.controller.TaskmController;
import org.nishp.springboot.pojo.Task;
import org.nishp.springboot.repo.TaskRepository;
import org.nishp.springboot.service.TaskManagementService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(scripts="dummyTestData.sql")
public class TaskManagerBackendTests {

	@Mock
	private TaskManagementService services;

	@Mock
	private TaskRepository taskRepo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addTaskTest() {
		assertEquals(true, services.taskExists(1));
	}

	@Test
	public void testServerUp() {
		TaskmController mainController = new TaskmController();
		assertEquals("OK", mainController.ping());
	}

	@Test
	public void testGetAllTasks() {
		List<Task> allTasks = services.getAllTasks();
		assertEquals(3, allTasks.size());
	}

}
