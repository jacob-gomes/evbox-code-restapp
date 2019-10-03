package com.codeassignment.evbox.restapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MethodReferenceTest {
	
	public MethodReferenceTest() {}
	
	private Integer amount;
	
	MethodReferenceTest(Integer a) {
		System.out.println("Constructor"+a);
		this.amount = a;
	}
	
	
	@Test
	public void createNewSession()  {
		Consumer<Integer> funcInt1 = System.out::println;
		Consumer<Integer> funcInt2 = ((a) -> {System.out.println("funcInt2"+a);}); // lambda
		Consumer<Integer> funcInt3 = (this::methodReference); // object MR
		Consumer<Integer> funcInt4 = MethodReferenceTest::new; // constructor Referencing
		List<Consumer<Integer>> funcIntList = new ArrayList<>();
		
		funcIntList.add(funcInt1);
		funcIntList.add(funcInt2);
		funcIntList.add(funcInt3);
		funcIntList.add(funcInt4);
		funcIntList.add(MethodReferenceTest::staticMethodReference); // Static MR
		funcIntList.add(Integer::shortValue);
		
		for(Consumer<Integer> funcInt : funcIntList) {
			funcInt.accept(6);
		}
		
	//	funcInt1.callExecute();
		
		Function<Integer, MethodReferenceTest>  methodReferenceFunction = MethodReferenceTest::new;
		MethodReferenceTest methodReference = methodReferenceFunction.apply(6);
		System.out.println("Amount"+methodReference.amount);
		
		List<MethodReferenceTest> methodReferenceTestList = new ArrayList<>();
		methodReferenceTestList.add(methodReference);
		
		//this is applied on the object and not passed as a parameter
		methodReferenceTestList.forEach(MethodReferenceTest::arbituaryMethodReference); // arbituaury MR
	}

	private void methodReference(int a) {
		System.out.println("methodReference"+a);
	}
	
	private void arbituaryMethodReference() {
		System.out.println("arbituaryMethodReference");
	}
	
	private static void staticMethodReference(int a) {
		System.out.println("staticMethodReference"+a);
	}
	
}
