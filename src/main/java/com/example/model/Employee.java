package com.example.model;

import lombok.Data;

@Data
public class Employee {

	private int employeeId;
	private String employeeName;
	private int phoneNumber;
	
	public Employee(){
		
	}
	
	public Employee(int employeeId, String employeeName, int phoneNumber){
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.phoneNumber = phoneNumber;
	}
}
