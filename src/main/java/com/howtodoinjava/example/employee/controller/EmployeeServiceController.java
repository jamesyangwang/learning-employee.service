package com.howtodoinjava.example.employee.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.example.employee.beans.Employee;

@RestController
public class EmployeeServiceController {
	
	private static final LocalDateTime availableSince = LocalDateTime.now();
	private static final Map<Integer, Employee> employeeData = new HashMap<Integer, Employee>() {
		private static final long serialVersionUID = -7350954825954113114L;
		{
			put(111,new Employee(111,"Employee1"));
			put(222,new Employee(222,"Employee2"));
		}
    };
 
    @GetMapping(value = "/findEmployeeDetails/{employeeId}")
    public Employee getEmployeeDetails(@PathVariable int employeeId) {
        System.out.println("Getting Employee details for " + employeeId);
        Employee employee = employeeData.get(employeeId);
        if (employee == null) {
        	employee = new Employee(0, "N/A");
        }
        return employee;
    }

	public boolean isServiceUp() {
		return true;
	}

	public LocalDateTime getAvailableSince() {
		return availableSince;
	}

}
