package com.codeassignment.evbox.restapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StreamTest {
	
	@Test
	public void createNewSession() throws Exception {
		Stream<Integer> stream =  Arrays.asList(2,3,4,5,6).stream();
		Stream<Integer> parallelStream =  Arrays.asList(2,3,4,5,6).parallelStream();
		//System.out.println(stream.allMatch(StreamTest::predicate));
		System.out.println(stream.filter(StreamTest::predicate).collect(Collectors.toList()));
		//System.out.println(parallelStream.anyMatch(StreamTest::predicate));
		
		//List<Integer> arrayList = stream.map(a -> a*a).collect(Collectors.toList());
		//arrayList.forEach(System.out::println);
	}
	
	static boolean predicate(int a) {
		System.out.println(a);
		return a%2 == 0;
	}
}

