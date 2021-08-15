package com.dypiemr.task.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dypiemr.task.model.*;

public interface TaskRepository extends JpaRepository<TaskModel, Long>{
	public List<TaskModel> findAll();
    public TaskModel findById(int theId);
    public TaskModel findByTaskHolderName(String theName);
	public TaskModel save(TaskModel theSeries);
	public void deleteById(int theId);
}