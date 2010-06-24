package org.jamescarr.googlecollections;

public class Employee {

	private final String name;
	private final int age;

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
