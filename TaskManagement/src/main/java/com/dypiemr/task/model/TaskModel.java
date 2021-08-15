package com.dypiemr.task.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class TaskModel {

	// define fields
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="taskId")
	private long id;
	@Column(name="taskHolderName")
	private String taskHolderName;

	@Column(name="taskDate")
	private String taskDate;
	
	@Column(name="taskStatus")
	private String taskStatus;
	
	@Column(name="taskName")
	private String taskName;
	// define constructors
	
	public TaskModel() {
		
	}

	public TaskModel(String taskHolderName, String taskDate, String taskStatus, String taskName) {
		this.taskHolderName = taskHolderName;
		this.taskDate = taskDate;
		this.taskStatus = taskStatus;
		this.taskName = taskName;
	}


	// define getter/setter

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaskHolderName() {
		return taskHolderName;
	}

	public void setTaskHolderName(String taskHolderName) {
		this.taskHolderName = taskHolderName;
	}

	public String getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public String toString() {
		return "TaskModel [taskId=" + id + ", taskHolderName=" + taskHolderName + ", taskDate=" + taskDate + ", taskStatus="
				+ taskStatus + ", taskName=" + taskName + "]";
	}
	
		
}

