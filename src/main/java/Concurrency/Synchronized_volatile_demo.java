package Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Synchronized_volatile_demo {
	//To avoid visibility problem
	//The value is immediately flushed from local thread cache to shared cache.
	private volatile static int counter = 0;
	
	//In built Volatite and Synchronized methods
	private static AtomicInteger synAndVolatile = new AtomicInteger(5);

	public static void main(String[] args) {
		Task1 t1= new Task1();
		Task2 t2=new Task2();
		
		Thread thread11= new Thread(t1);
		Thread thread12= new Thread(t1);
		Thread thread13= new Thread(t1);

		thread11.start();
		thread12.start();
		thread13.start();
		System.out.println("Counter Value in main thread -->"+counter);


		
		Thread thread1= new Thread(t2);
		Thread thread2= new Thread(t2);
		Thread thread3= new Thread(t2);

		thread1.start();
		thread2.start();
		thread3.start();
		System.out.println("AtomicInt in main thread-->"+synAndVolatile.get());
	}
	//To avoid synchronization issue(read/write problem) b/w threads
	//Synchronized -> Only one thread can execute this block at a time
	public int increment() {  
		synchronized (this) { //Synchronized block 
			return counter++;

		}
	}
	
	public int atomicIntIncreament() {
		return synAndVolatile.incrementAndGet();
	}

}

class Task1 implements Runnable {

	@Override
	public void run() {
		Synchronized_volatile_demo obj = new Synchronized_volatile_demo();
		int val = obj.increment();
		System.out.println("Value--->" + val);
	}

}

class Task2 implements Runnable {

	@Override
	public void run() {
		Synchronized_volatile_demo obj = new Synchronized_volatile_demo();
		int val = obj.atomicIntIncreament();
		System.out.println("Value_AtomicInteger--->" + val);
	}

}




