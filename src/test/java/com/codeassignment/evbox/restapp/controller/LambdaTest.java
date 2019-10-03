package com.codeassignment.evbox.restapp.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LambdaTest {
	
	public LambdaTest() {}
	
	LambdaTest(FunctionInt funcInt) {
		funcInt.callExecute();
	}
	
	LambdaTest(Comparator<Integer> comp) {
		System.out.println(comp.toString());
	}
	
	
	@Test
	public void createNewSession()  {
		FunctionInt funcInt1 = ((a,b) -> (a+b));
		FunctionInt funcInt2 = ((a,b) -> {return a-b;});
		FunctionInt funcInt3 = (this::runableInvocation);
		List<FunctionInt> funcIntList = new ArrayList<>();
		
		funcIntList.add(funcInt1);
		funcIntList.add(funcInt2);
		funcIntList.add(funcInt3);
		funcIntList.add((a,b) -> (a%b));
		
		for(FunctionInt funcInt : funcIntList) {
			usingCodeAsData(4,3,funcInt);
		}
		
		funcInt1.callExecute();
		
		//Ambigous Compile time error
		//LambdaTest = new LambdaTest((a,b) -> {return a-b;});
		
		new LambdaTest(new FunctionInt(){ 
			public int exec(int a, int b) 
			{return a-b;}
			});
	}

	private int runableInvocation(int a, int b) {
		return a*b;
	}
	
	private void usingCodeAsData(int a, int b, FunctionInt funcInt) {
		System.out.println(funcInt.exec(4, 3));
	}
	
}



@FunctionalInterface
interface FunctionInt{
	int exec(int a, int b);
	
	default void callExecute() {
		System.out.println(exec(5,1));
	}
}