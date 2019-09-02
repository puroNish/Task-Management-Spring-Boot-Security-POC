package org.nishp.springboot.repo;

import org.nishp.springboot.pojo.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer>{
	

}
