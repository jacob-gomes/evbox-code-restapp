package com.codeassignment.evbox.restapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class WaitAndNotifyMethodTesting {
	
	List<Integer> resourceToBeFiled = new ArrayList<>(4);

	@Test
	public void producerConsumerProblem() throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		List<Callable<Void>> runnableThreadList = new ArrayList<>();
		runnableThreadList.add(this::produce);
	//	runnableThreadList.add(this::produce);
		runnableThreadList.add(this::consume);
		executorService.invokeAll(runnableThreadList);
		
	}
	
	private Void produce() throws InterruptedException {
		for(int i = 0; i < 4; i++) {
			synchronized (resourceToBeFiled) {
				if(resourceToBeFiled.size() == 2) {
					resourceToBeFiled.wait();
				}
				resourceToBeFiled.add(i);
				System.out.println("Producer "+ resourceToBeFiled.toString());
			}			
		}
		return null;
	}
	
	private Void consume() throws InterruptedException {		
		for(int i = 1; i > -1; i--) {
			Thread.sleep(1000);
			resourceToBeFiled.remove(i);
			synchronized (resourceToBeFiled) {
				resourceToBeFiled.notify();				
				System.out.println("Consumer "+ resourceToBeFiled.toString());
			}			
		}
		return null;
	}
	
}
