package org.jamescarr.googlecollections;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class EmployeeRepository {
	private final List<Employee> employees = new ArrayList<Employee>();
	public void save(Employee... employees) {
		for(Employee employee : employees){
			this.employees.add(employee);
		}
	}
	public Employee findByName(final String name) {
		return Iterables.find(employees, new Predicate<Employee>() {
			@Override
			public boolean apply(Employee employee) {
				return employee.getName().equals(name);
			}
		});
	}
	public Iterable<Employee> findEmployeesOver(final int age) {
		return Iterables.filter(employees, new Predicate<Employee>() {
			@Override
			public boolean apply(Employee employee) {
				return employee.getAge() > age;
			}
		});
	}
	public List<String> getAllEmployeeNames() {
		return Lists.transform(employees, new Function<Employee, String>() {
			@Override
			public String apply(Employee employee) {
				return employee.getName();
			}
		});
	}
	

}
