package Concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorService_Runnable_Demo {
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService_Runnable_Demo demo = new ExecutorService_Runnable_Demo();
		demo.scheduledPool();

	}

	//Task are in blocking queue -> Fixed no of threads
	public void fixedThreadPool() {
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 4; i++) {
			service.submit(new Task_Runnable());
		}
	}
	
	//Only one task in Synchronous Queue 
	//Creates new thread everytime if all threads are busy
	//Idle time for each thread is 60s then that thread is killed
	public void cachedThreadPool() throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 4; i++) {
			service.submit(new Task_Runnable());
		}
	}
	
	public void scheduledPool() {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
		
		service.scheduleAtFixedRate(new Task_Runnable(), 2, 5, TimeUnit.SECONDS);
		service.scheduleWithFixedDelay(new Task_Runnable(), 2, 5, TimeUnit.SECONDS);		
	}

}

class Task_Runnable implements Runnable {

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Thread Name---> " + t.getName());

	}

}


