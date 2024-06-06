package com.ezplatform.mvc.dao;

import com.ezplatform.mvc.bean.A20220606_RestFulTest_Employee;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository(value = "empDao")
public class A20220606_RestFulTest_EmployeeDao {
	private static Map<Integer, A20220606_RestFulTest_Employee> employees = null;
	private static Integer initId = 2016;
	static{
		employees = new HashMap<Integer, A20220606_RestFulTest_Employee>();
		employees.put(1001, new A20220606_RestFulTest_Employee(1001, "E-AA", "aa@163.com", 1));
		employees.put(1002, new A20220606_RestFulTest_Employee(1002, "E-BB", "bb@163.com", 1));
		employees.put(1003, new A20220606_RestFulTest_Employee(1003, "E-CC", "cc@163.com", 0));
		employees.put(1004, new A20220606_RestFulTest_Employee(1004, "E-DD", "dd@163.com", 0));
		employees.put(1005, new A20220606_RestFulTest_Employee(1005, "E-EE", "ee@163.com", 1));
	}

	public A20220606_RestFulTest_EmployeeDao() {
	}

	public void save(A20220606_RestFulTest_Employee employee) {
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		employees.put(employee.getId(), employee);
	}

	public Collection<A20220606_RestFulTest_Employee> getAll() {
		return employees.values();
	}

	public A20220606_RestFulTest_Employee get(Integer id){
		return employees.get(id);
	}

	public void delete(Integer id){
		employees.remove(id);
	}



}
