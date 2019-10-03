package com.codeassignment.evbox.restapp.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExecutorsUsingLambdaTest {
	
	@Test
	public void createNewSession() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		Future<String> future = executor.submit(() -> ("Hello callable"));
		executor.submit(this::runableInvocation);
		System.out.println(future.get());
	}

	private void runableInvocation() {
		System.out.println("Hello Runnable");
	}
}

