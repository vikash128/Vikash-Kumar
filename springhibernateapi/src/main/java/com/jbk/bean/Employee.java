package com.jbk.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "status")
	private String status;
	
	public Employee() {
		
	}

	public Employee(int id, String name, String status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}
	
	public Employee(HttpStatus badRequest) {
		//this.badRequest = badRequest;
	}
	
	public Employee(Employee employee, HttpStatus badRequest) {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	
}
