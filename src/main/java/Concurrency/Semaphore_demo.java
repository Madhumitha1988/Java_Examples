package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Semaphore_demo {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);
		ExecutorService service = Executors.newFixedThreadPool(5);
		IntStream.range(0,10).forEach(i -> service.submit(new SemaphoreTask(semaphore)));
	}

}

class SemaphoreTask implements Runnable {
	Semaphore semaphore;

	SemaphoreTask(Semaphore s) {
		this.semaphore = s;
	}

	@Override
	public void run() {
		semaphore.acquireUninterruptibly();
		// call to any slow service
		System.out.println("Queye length--> "+semaphore.getQueueLength());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		semaphore.release();
	}

}