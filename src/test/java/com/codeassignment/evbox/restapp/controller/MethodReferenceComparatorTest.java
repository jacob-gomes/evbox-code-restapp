package com.codeassignment.evbox.restapp.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MethodReferenceComparatorTest {	
	
	@Test
	public void createNewSession()  {
		List <Person> personList = new ArrayList<>();
		personList.add(new Person(1 , 40, 59999));
		personList.add(new Person(2 , 38, 40000));
		personList.add(new Person(3 , 37, 60000));
		personList.add(new Person(4 , 36, 58000));
		personList.add(new Person(5 , 35, 57000));
		
		System.out.println("Self");
		Collections.sort(personList);
		personList.forEach(Person::print);
		
		System.out.println("id Desc");
		Collections.sort(personList, MethodReferenceComparatorTest::idComparison);
		personList.forEach(Person::print);
		
		System.out.println("age");
		Collections.sort(personList, MethodReferenceComparatorTest::ageComparison);
		personList.forEach(Person::print);
		
		System.out.println("wage");
		Collections.sort(personList, MethodReferenceComparatorTest::wageComparison);
		personList.forEach(Person::print);
		
	}	
	
	private static int idComparison(Person a, Person b) {
		return   b.id -a.id;
	}
	
	private static int ageComparison(Person a, Person b) {
		return a.age - b.age;
	}
	
	private static int wageComparison(Person a, Person b) {
		return a.wage - b.wage;
	}
	
	
	private class Person implements Comparable{
		Integer id;
		Integer age;
		Integer wage;
		
		Person (Integer id,Integer age,Integer wage){
			this.id = id;
			this.age = age;
			this.wage = wage;
		}
		
		void print() {
			System.out.println("id=" + this.id
					+ " age="+ this.age
					+ " wage=" + this.wage);
		}
		
		@Override
		public int compareTo(Object o) {
			Person p = (Person)o;
			return this.id - p.id;
		}
		
	}
}

