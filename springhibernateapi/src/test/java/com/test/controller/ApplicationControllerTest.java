package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import com.jbk.bean.Employee;
import com.jbk.controller.ApplicationController;
import com.jbk.service.ApplnServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationControllerTest {
	
	@InjectMocks
	ApplicationController applicationController;
	
	@Mock
	ApplnServiceImpl aaplicationService;
	
	@Test
	public void showemployeeByNameTest() {
		
		List<Employee> listofEmployee = new ArrayList<>();
		
		when(aaplicationService.showemployeeByName("Sagar")).thenReturn(listofEmployee);
		
		List<Employee> result = applicationController.showemployeeByName("Sagar");
		
		Assert.assertNotNull(result);
	}
	
	@Test
	public void primeNumberTest() {
		
		String str = "11";
		when(aaplicationService.primeNumber(29)).thenReturn(str);
		
		System.out.println(aaplicationService.primeNumber(29));
	
		String result = applicationController.primeNumber(29);
		
		Assert.assertNotNull(result);
	}
	
	@Test
	public void febonansiSeriesTest() {
		
		String str = "10";
		
		when(aaplicationService.febonansiSeries(10)).thenReturn(str);
		System.out.println(aaplicationService.febonansiSeries(10));
		String result = applicationController.febonansiSeries(10);
		
		Assert.assertNotNull(result);
	}

}
