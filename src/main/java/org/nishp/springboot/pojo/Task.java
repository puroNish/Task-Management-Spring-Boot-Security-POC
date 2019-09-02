package org.nishp.springboot.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;

	@Column
	private String taskName;

	@Column
	private String taskDetails;

	@Column
	private String taskCreated;

	@Column
	private String taskScheduled;

	@Column
	private boolean taskExists;

	@Column
	private String createdBy;

	public Task() {
		super();
		this.setTaskExists(true);
		this.setTaskCreated(String.valueOf(java.time.LocalDateTime.now()));
	}

	public Task(Integer taskId, String taskName, String taskDetails, String taskCreated, String taskScheduled,
			boolean taskExists, String createdBy) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDetails = taskDetails;
		this.taskScheduled = taskScheduled;
		this.createdBy = createdBy;
		this.setTaskExists(true);
		this.setTaskCreated(String.valueOf(java.time.LocalDateTime.now()));
	}

	public String getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskCreated() {
		return taskCreated;
	}

	public void setTaskCreated(String taskCreated) {
		this.taskCreated = taskCreated;
	}

	public String getTaskScheduled() {
		return taskScheduled;
	}

	public void setTaskScheduled(String taskScheduled) {
		this.taskScheduled = taskScheduled;
	}

	public boolean isTaskExists() {
		return taskExists;
	}

	public void setTaskExists(boolean taskExists) {
		this.taskExists = taskExists;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskCreated=" + taskCreated + ", taskScheduled="
				+ taskScheduled + "]";
	}
}
