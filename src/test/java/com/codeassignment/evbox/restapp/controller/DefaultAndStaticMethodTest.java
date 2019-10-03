package com.codeassignment.evbox.restapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultAndStaticMethodTest implements Interface1,Interface2,Interface3 {
	
	@Test
	public void createNewSession() throws Exception {
		DefaultAndStaticMethodTest defaultAndStaticMethodTest = new DefaultAndStaticMethodTest();
		defaultAndStaticMethodTest.say();
		Interface1.sayStatic();
		sayDefault(); //Interface3 is called bcoz Interface3 extends Interface1
		
	}

	@Override
	public void say() {// has to be overridden because of diamond issue
		Interface2.super.say();
	}
}


interface Interface1 {
	default void say() {
		System.out.println("Default Interface1");
	}
	
	static void sayStatic() {
		System.out.println("Static Interface1");
	}
	
	default void sayDefault() {
		System.out.println("sayDefault in Interface1");
	}
}

interface Interface2 {
	default void say() {
		System.out.println("Interface2");
	}
}

interface Interface3 extends Interface1{
	default void sayDefault() {
		System.out.println("sayDefault in Interface3");
	}
}

