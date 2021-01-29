package com.jbk.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.bean.Employee;

@Repository
public class ApplnDaoImpl implements ApplicationDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<String> printMessage() {
		List<String> list = new ArrayList<>();
		list.add("Vikash");
		list.add("Prabhu");
		list.add("Suruti");

		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}

		return list;
	}
	
	@Override
	public Map<String, String> printData() {
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("1", "Pascal");
		hashMap.put("2", "Soren");
		hashMap.put("3", "Marco");
		
		for(Map.Entry<String, String> map : hashMap.entrySet()) {
			System.out.println(map.getKey()+ "" +map.getValue());
		}
		
		return hashMap;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction txns = session.beginTransaction();
		session.save(employee);
		txns.commit();
		session.close();
		//session.save(employee);
		return employee;
	}

	@Override
	public List<Employee> getEmployee() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> listEmployee = criteria.list();
		System.out.println(listEmployee);
		return listEmployee;
	}

	@Override
	public Employee getemployeebyId(int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		System.out.println(employee);
		return employee;
	}

	@Override
	public List<Employee> showemployeeByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query<Employee> query = session.createQuery("FROM Employee E where E.name=:name");
		query.setParameter("name", name);
		List<Employee> listEmployee = query.list();
		System.out.println(listEmployee);
		return listEmployee;
	}

	@Override
	public List<Employee> showemployeeByStatus(String status) {
		Session session = sessionFactory.getCurrentSession();
		Query<Employee> query = session.createQuery("FROM Employee E where E.status=:status");
		query.setParameter("status", status);
		List<Employee> listEmp = query.list();
		System.out.println(listEmp);
		return listEmp;
	}

	@Override
	public List<Employee> showEmployee() {
		Session session = sessionFactory.getCurrentSession();
		Query<Employee> listEmp = session.createQuery("FROM Employee");
		List<Employee> list = listEmp.list();
		System.out.println(list);
		return list;
	}

	@Override
	public Employee update(Employee emp, int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		employee.setId(emp.getId());
		employee.setName(emp.getName());
		employee.setStatus(emp.getStatus());
		session.update(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee emplo, int id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, id);
		emp.setId(emplo.getId());
		emp.setName(emplo.getName());
		emp.setStatus(emplo.getStatus());
		session.saveOrUpdate(emp);
		transaction.commit();
		return emp;
	}
	
	public Employee deleteEmployee(Employee emp, int id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		//Employee emp = getemployeebyId(id);
		emp = (Employee) session.get(Employee.class, id);
		emp.setId(emp.getId());
		emp.setName(emp.getName());
		emp.setStatus(emp.getStatus());
		session.delete(emp);
		transaction.commit();
		return emp;
	}

	@Override
	public void deleteEmployee2(int id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction txns = session.beginTransaction();
		Employee emp = getemployeebyId(id);
		session.delete(emp);
		txns.commit();
	}

	@Override
	public List<Employee> getEmployeeByType() {
		List<Employee> list = new ArrayList<>();
		return list;
	}

	@Override
	public List<Employee> getEmployeeByWorking() {
		List<Employee> list = new ArrayList<>();
		return list;
	}

	/*
	 * @Override public String addCountry(Country country) { Session session =
	 * sessionFactory.getCurrentSession(); Transaction tnsxn =
	 * session.beginTransaction(); session.save(country); tnsxn.commit();
	 * session.close(); return "Country added in database successfully !"; }
	 */

}
