package com.jbk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.bean.Employee;
import com.jbk.service.ApplnServiceImpl;

@CrossOrigin
@RestController
@RequestMapping(value = "/testapi")    //http://localhost:8585/testapi/showemployee
      // Controller -> Service -> Dao class -> Database
public class ApplicationController {
	
	@Autowired
	private ApplnServiceImpl applnServiceImpln;
	
	@GetMapping(value = "/getlist")
	public List<String> printMessage() {
		List<String> list = applnServiceImpln.printMessage();
		if(list != null) {
			
		}
		return list;
	}
	
	@GetMapping(value = "/getdata")
	public Map<String, String> printData() {
		Map<String, String> map = applnServiceImpln.printData();
		return map;
	}
	
	@PostMapping(value = "/addemployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee emp = applnServiceImpln.addEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/getemployee")
	public List<Employee> getEmployee() {
		List<Employee> listEmployee = applnServiceImpln.getEmployee();
		return listEmployee;
	}
	
	@GetMapping(value = "/employeebyid/{id}")
	public Employee getemployeebyId(@PathVariable("id") int id) {
		Employee employee = applnServiceImpln.getemployeebyId(id);
		return employee;
	}
	
	@GetMapping(value = "/employeebyname/{name}")
	public List<Employee> showemployeeByName(@PathVariable("name") String name) {
		List<Employee> listEmp = applnServiceImpln.showemployeeByName(name);
		return listEmp;
	}
	
	@GetMapping(value = "/employeebystatus/{status}")
	public List<Employee> showemployeeByStatus(@PathVariable("status") String status) {
		List<Employee> list = new ArrayList<Employee>();
		list = applnServiceImpln.showemployeeByStatus(status);
		return list;
	}
	
	@GetMapping("/showemployee")
	public List<Employee> showEmployee() {
		List<Employee> listEmployee = applnServiceImpln.showEmployee();
		return listEmployee;
	}
	
	@PutMapping(value = "/updateemployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
		emp.setId(id);
		Employee updateEmployee = applnServiceImpln.updateEmployee(emp, emp.getId());
		if(updateEmployee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		applnServiceImpln.update(emp, emp.getId());
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteemployee")
	public ResponseEntity<Employee> deleteEmployee(@RequestBody Employee emp) {
		
		Employee employee = applnServiceImpln.deleteEmployee(emp, emp.getId());
		if(employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteemployee/{id}")
	public ResponseEntity<Employee> deleteEmployee2(@PathVariable int id) {
		
		Employee emp = applnServiceImpln.getemployeebyId(id);
		
		if(emp == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		
		applnServiceImpln.deleteEmployee2(id);
		
		return new ResponseEntity<Employee>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/primenumber/{number}")
	public String primeNumber(@PathVariable int number) {
		String str = applnServiceImpln.primeNumber(number);
		return str;
	}
	
	@GetMapping(value = "/febonanci-series/{totalnumber}")
	public String febonansiSeries(@PathVariable int totalnumber) {
		return applnServiceImpln.febonansiSeries(totalnumber);
	}
	
}
