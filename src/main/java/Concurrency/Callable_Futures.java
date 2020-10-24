package Concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callable_Futures {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(10);
		Future<String> f = service.submit(new Task_callable());

		f.cancel(true);
		if (f.isCancelled()) {
			System.out.println("Task is cancelled!!!");
		}
		if (f.isDone() && !f.isCancelled()) {
			System.out.println("Task is completed!!!");
			System.out.println(f.get());
		}
		if (!f.isCancelled()) {
			System.out.println(f.get());// Blocking operation
		}
		System.out.println("Main thread completed --> " + Thread.currentThread().getName());
	}

}

class Task_callable implements Callable<String> {
	@Override
	public String call() throws Exception {
		Thread.sleep(300);
		return Thread.currentThread().getName();
	}
}
