package com.codeassignment.evbox.restapp.controller;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UnitTest {
	
	@Test
	public void createNewSession() throws Exception {
		Stream<Integer> stream =  Arrays.asList(2,3,4,5,6).stream();
		System.out.println(stream.allMatch(UnitTest::predicate));
		
		//basic datatypes
		final short a = 24; // final required
		final short b = 42;// final required
		short c = a + b;
		final byte d = 24; // final required
		final byte e = 123;// final required
		byte f = d | e;
		
		//int exceed = 12345678987; //compile time error
		int exceed = 123456789;
		exceed = exceed*1000000+87654321;
		System.out.println(exceed);
		
		Integer[] array = new Integer[5];
		for(int i = 0; i<5; i++) {
			array[i] = i;
		}
		
		Stream.of(array).forEach(System.out::println);
	}
	
	static boolean predicate(int a) {
		System.out.println(a);
		return a%2 == 0;
	}
}

