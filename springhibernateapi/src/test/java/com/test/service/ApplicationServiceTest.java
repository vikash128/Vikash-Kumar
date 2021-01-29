package com.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import com.jbk.bean.Employee;
import com.jbk.dao.ApplnDaoImpl;
import com.jbk.service.ApplnServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceTest {
	
	@InjectMocks
	ApplnServiceImpl aaplicationService;
	
	@Mock
	ApplnDaoImpl applicationDao;
	
	@Test
	public void forServiceClassTestingPurposeMethodWrittenTest() {
		
		List<Employee> listofEmp = new ArrayList<>();
 		when(applicationDao.getEmployeeByType()).thenReturn(listofEmp);
		List<Employee> result = aaplicationService.forServiceClassTestingPurposeMethodWritten("retried");
		
		Assert.assertNotNull(result);
	}
	
	@Test
	public void forServiceClassTestingPurposeMethodWrittenTest1() {
		
		List<Employee> listofEmp = new ArrayList<>();
 		when(applicationDao.getEmployeeByWorking()).thenReturn(listofEmp);
		List<Employee> result = aaplicationService.forServiceClassTestingPurposeMethodWritten("working");
		
		Assert.assertNotNull(result);
	}
	
	@Test
	public void forServiceClassTestingPurposeMethodWrittenTest2() {
		
		List<Employee> result = aaplicationService.forServiceClassTestingPurposeMethodWritten("Sagar");
		
		Assert.assertNull(result);
	}
	
	@Test
	public void primeNumberTest() {
		
		String result = aaplicationService.primeNumber(29);
		
		boolean flag = false;
		
		for(int i = 2; i <= 29/2; i--) {
			if(29 % i == 0) {
				flag = true;
				break;
			}
		}
		
		if(true) {
			System.out.println(29+ " = Prime Number.");
		}
		else {
			System.out.println(29+ " = Not Prime Number.");
		}
		
		Assert.assertNotNull(result);
		
	}
	
	@Test
	public void primeNumberTest1() {
		
		String result = aaplicationService.primeNumber(9);

		boolean flag = false;

		for (int i = 2; i <= 9 / 2; i++) {
			if (9 % i == 0) {
				flag = true;
				break;
			}
		}

		if (false) {
			System.out.println(9 + " = Prime Number.");
		}else {
			System.out.println(9 + " = Not Prime Number.");
		}
		
		Assert.assertNotNull(result);
	}
	
	@Test
	public void febonansiSeriesTest() {
		
		String result = aaplicationService.febonansiSeries(5);
		
		int firstNumber = 0;
		int secondNumber = 1;
		int sum;
		
		System.out.print(firstNumber);
		
		int i = 1;

		while (i < 5) {
			sum = firstNumber + secondNumber;
			System.out.print(", " + secondNumber);
			firstNumber = secondNumber;
			secondNumber = sum;
			i++;
		}
		
		Assert.assertNotNull(result);
	}
}
