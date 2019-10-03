package com.codeassignment.evbox.restapp.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TreeSetTest {

	@Test
	public void testTreeSet() {
		Set<Employee> unsortedSet = new HashSet<>();
		unsortedSet.add(new Employee("ABC",10,2));
		unsortedSet.add(new Employee("DEF",13,1));
		unsortedSet.add(new Employee("GHI",12,4));
		unsortedSet.add(new Employee("JKL",19,3));
		
		Set<Employee> naturalEmployeeSorting = new TreeSet<>(unsortedSet);
		Set<Employee> nameEmployeeSorting = new TreeSet<>(this::nameCompare);
		Set<Employee> ageEmployeeSorting = new TreeSet<>(this::ageCompare);
		Set<Employee> rollNumberEmployeeSorting = new TreeSet<>(this::rollNumberCompare);
		Set<Employee> noCompareEmployeeSorting = new TreeSet<>(this::noCompare);

		naturalEmployeeSorting.addAll(unsortedSet);
		nameEmployeeSorting.addAll(unsortedSet);
		ageEmployeeSorting.addAll(unsortedSet);
		rollNumberEmployeeSorting.addAll(unsortedSet);
		noCompareEmployeeSorting.addAll(unsortedSet);
		
		naturalEmployeeSorting.forEach(System.out::println);
		
	}
	
	public int nameCompare(Employee emp1, Employee emp2) {
		return emp1.getName().compareTo(emp2.getName());
	}
	
	public int ageCompare(Employee emp1, Employee emp2) {
		return emp1.getAge() - emp2.getAge();
	}
	
	public int rollNumberCompare(Employee emp1, Employee emp2) {
		return emp1.getRollNumber() - emp2.getRollNumber();
	}
	
	public int noCompare(Employee emp1, Employee emp2) {
		return 1;
	}
}

class Employee implements Comparable<Employee>{
	private String name;
	
	private Integer age;
	
	private Integer rollNumber;
	
	

	public Employee(String name, Integer age, Integer rollNumber) {
		this.name = name;
		this.age = age;
		this.rollNumber = rollNumber;
	}
	
	@Override
	public int compareTo(Employee employee) {
		return this.rollNumber - employee.rollNumber;
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the rollNumber
	 */
	public Integer getRollNumber() {
		return rollNumber;
	}

	/**
	 * @param rollNumber the rollNumber to set
	 */
	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", rollNumber=" + rollNumber + "]";
	}
	
	
}