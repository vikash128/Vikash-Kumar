package com.jbk.dao;

import java.util.List;
import java.util.Map;

import com.jbk.bean.Employee;

public interface ApplicationDao {
	
	public List<String> printMessage();
	public Map<String, String> printData();
	public Employee addEmployee(Employee employee);
	public List<Employee> getEmployee();
	public Employee getemployeebyId(int id);
	public List<Employee> showemployeeByName(String name);
	public List<Employee> showemployeeByStatus(String status);
	public List<Employee> showEmployee();
	public Employee updateEmployee(Employee emplo, int id);
	public Employee update(Employee emp, int id);
	public Employee deleteEmployee(Employee emp, int id);
	public void deleteEmployee2(int id);

	//For testing purpose written this method
	public List<Employee> getEmployeeByType();
	public List<Employee> getEmployeeByWorking();
}
