package org.jamescarr.googlecollections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;

import static java.util.Arrays.asList;

public class EmployeeRepositoryTest {
	private static final Employee ROGER = new Employee("Roger", 58);
	private static final Employee JESSICA = new Employee("Jessica", 28);
	private static final Employee RYAN = new Employee("Ryan", 23);
	private static final Employee JAMES = new Employee("James", 30);
	private EmployeeRepository employeeRepository;
	
	@Before
	public void beforeEach(){
		employeeRepository = new EmployeeRepository();
	}
	
	@Test
	public void shouldBeAbleToFindEmployeeByName(){
		employeeRepository.save(JAMES, RYAN, JESSICA, ROGER);
		
		Employee employee = employeeRepository.findByName("James");
		
		assertThat(employee.getName(), equalTo("James"));
		assertThat(employee.getAge(), equalTo(30));
	}
	@Test
	public void shouldFilterEmployeesByAge(){
		Iterable<Employee> oldEmployees = asList(JAMES, ROGER);
		employeeRepository.save(JAMES, RYAN, JESSICA, ROGER);
		
		Iterable<Employee> employees = employeeRepository.findEmployeesOver(29);
		
		assertTrue(Iterables.elementsEqual(oldEmployees, employees));
		assertThat(Iterables.size(employees), equalTo(2));
	}
	
	@Test
	public void shouldGetAllEmployeeNames(){
		employeeRepository.save(JAMES, RYAN, JESSICA, ROGER);
		
		List<String> names = employeeRepository.getAllEmployeeNames();
		
		assertThat(names, equalTo(asList("James", "Ryan", "Jessica", "Roger")));
	}
}
