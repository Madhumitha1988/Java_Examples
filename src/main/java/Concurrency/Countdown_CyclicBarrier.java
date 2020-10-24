package Concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Countdown_CyclicBarrier {
	public static void main(String[] args) throws InterruptedException {
		Countdown_CyclicBarrier demo = new Countdown_CyclicBarrier();
		demo. barrier_method();
	}

	public void latch_method() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(5);
		CountDownLatch latch = new CountDownLatch(3);
		IntStream.rangeClosed(0, 2).forEach(i -> service.submit(new CountDown_Task(latch)));
		
		latch.await(); // Main thread waits here till countdown is 0;
		
		System.out.println("Main completed");

	}
	public void barrier_method() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(5);
		CyclicBarrier barrier = new CyclicBarrier(3);
		IntStream.rangeClosed(0, 2).forEach(i -> service.submit(new CyclicBarrier_Task(barrier)));
		System.out.println("Main completed");//Main thread doen't wait for anything here


	}

}

class CountDown_Task implements Runnable {
	CountDownLatch latch;

	CountDown_Task(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId());
		latch.countDown();
	}

}
class CyclicBarrier_Task implements Runnable{
	CyclicBarrier barrier;
	CyclicBarrier_Task(CyclicBarrier barrier){
		this.barrier=barrier;
	}
	

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId());
		try {
			barrier.await();  //It waits here till all 3 thread attains here\
			System.out.println("After arrival");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
}

