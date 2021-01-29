package com.jbk.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.bean.Employee;
import com.jbk.dao.ApplnDaoImpl;

@Service
public class ApplnServiceImpl implements ApplicationService {
	
	@Autowired
	private ApplnDaoImpl applnDaoImpln;

	@Override
	public List<String> printMessage() {
		List<String> list = applnDaoImpln.printMessage();
		return list;
	}
	
	@Override
	public Map<String, String> printData() {
		return applnDaoImpln.printData();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return applnDaoImpln.addEmployee(employee);
	}

	@Override
	public List<Employee> getEmployee() {
		return applnDaoImpln.getEmployee();
	}

	@Override
	public Employee getemployeebyId(int id) {
		Employee emp = applnDaoImpln.getemployeebyId(id);
		return emp;
	}

	@Override
	public List<Employee> showemployeeByName(String name) {
		List<Employee> listEmployee = applnDaoImpln.showemployeeByName(name);
		return listEmployee;
	}

	@Override
	public List<Employee> showemployeeByStatus(String status) {
		List<Employee> list = applnDaoImpln.showemployeeByStatus(status);
		return list;
	}

	@Override
	public List<Employee> showEmployee() {
		List<Employee> listEmployee = applnDaoImpln.showEmployee();
		return listEmployee;
	}

	@Override
	public Employee updateEmployee(Employee emplo, int id) {
		Employee employeeUpdate = applnDaoImpln.updateEmployee(emplo, id);
		return employeeUpdate;
	}

	@Override
	public Employee update(Employee emp, int id) {
		Employee employee = applnDaoImpln.update(emp, id);
		return employee;
	}

	@Override
	public Employee deleteEmployee(Employee emp, int id) {
		return applnDaoImpln.deleteEmployee(emp, id);
	}

	@Override
	public void deleteEmployee2(int id) {
		applnDaoImpln.deleteEmployee2(id);
	}

	@Override
	public List<Employee> forServiceClassTestingPurposeMethodWritten(String type) {
		List<Employee> listofEmployee = null;
		if(type.equals("retried")) {
			listofEmployee = applnDaoImpln.getEmployeeByType();
		}else if(type.equals("working")) {
			listofEmployee = applnDaoImpln.getEmployeeByWorking();
		}else {
			listofEmployee = null;
		}
		return listofEmployee;
	}
	
	@Override
	public String primeNumber(int number) {
		boolean flag = false;
		
		for(int i = 2; i<=number/2; i++) {
			if(number % i == 0) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println(number+ " is a prime number.");
		}else {
			System.out.println(number+ " is not a prime number.");
		}
		
		return "";
	}

	@Override
	public String febonansiSeries(int totalNumber) {

		int firstNumber = 0;
		int secondNumber = 1;
		int sum;
		
		System.out.print(firstNumber);
		
		int i = 1;

		while (i < totalNumber) {
			sum = firstNumber + secondNumber;
			System.out.print(", " + secondNumber);
			firstNumber = secondNumber;
			secondNumber = sum;
			i++;
		}
		return "Febonanci series executed.....";
		
		/*
		 * for(int i = 1; i < totalNumber; i++) { sum = firstNumber + secondNumber;
		 * System.out.print(", " +secondNumber); firstNumber = secondNumber;
		 * secondNumber = sum; }
		 */
		
	}

	

	/*
	 * @Override public String addCountry(Country country) { String str =
	 * applnDaoImpln.addCountry(country); return str; }
	 */
	
}
