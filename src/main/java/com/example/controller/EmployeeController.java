package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;


@RestController
public class EmployeeController {

	@RequestMapping(value="/employees/{employeeId}", method=RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable("employeeId") int employeeId){
		Employee emp = new Employee(1, "Vivek", 123456789);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		
	}
	@RequestMapping(value="/employees/{page}/{size}", method=RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeedererj(@PathVariable("page") int page,
			@PathVariable("size") int size){
		Employee emp = new Employee(1, "Vivek", 123456789);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		
	}
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	private void addEmployee(@RequestBody Employee employee) {
		
		
	}
	
	@RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.PATCH)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateEmployee(@PathVariable("employeeId") int employeeId) {
		
	}
	
}
