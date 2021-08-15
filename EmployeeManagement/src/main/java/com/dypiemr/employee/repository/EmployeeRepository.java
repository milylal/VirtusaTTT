package com.dypiemr.employee.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dypiemr.employee.model.*;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{
	public List<EmployeeModel> findAll();
    public EmployeeModel findById(int theId);
	public EmployeeModel save(EmployeeModel theSeries);
	public void deleteById(int theId);
}