package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.stream.IntStream;

public class Phaser_demo {
	public static void main(String[] args) throws InterruptedException {
		Phaser_demo demo = new Phaser_demo();
		demo.phaser_as_barrier_method();
	}
	//
	public void phaser_as_latch_method() {
		ExecutorService service = Executors.newFixedThreadPool(5);
		Phaser phaser= new Phaser(3);
		//1,2.3
		IntStream.range(1, 4).forEach(i->service.submit(new Phaser_as_latch_Task(phaser)));
		phaser.awaitAdvance(0); // similar to latch.await
		System.out.println("Main End");
	}
	public void phaser_as_barrier_method() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(5);
		Phaser phaser= new Phaser(3);
		//1,2.3
		IntStream.range(1, 4).forEach(i->service.submit(new Phaser_as_Barrier_Task(phaser)));
		phaser.bulkRegister(2);
		IntStream.range(1, 3).forEach(i->service.submit(new Phaser_as_Barrier_Task(phaser)));

		System.out.println("Main End"); //Main thread doen't wait for anything here
	}
	

}


class Phaser_as_latch_Task implements Runnable {
	Phaser phaser;

	Phaser_as_latch_Task(Phaser phaser) {
		this.phaser = phaser;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId());
		phaser.arrive(); // Similar to latch.countdown
	}

}
class Phaser_as_Barrier_Task implements Runnable {
	Phaser phaser;

	Phaser_as_Barrier_Task(Phaser phaser) {
		this.phaser = phaser;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId());
		phaser.arriveAndAwaitAdvance(); // Similar to barrier.await
		System.out.println("after arrival");
	}

}