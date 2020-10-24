package Concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Completable_Future {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("In start main");
		Completable_Future demo = new Completable_Future();

		CompletableFuture<Object> obj = demo.single_threaded_CompletableFuture();
		// waiting for completable future to complete;
		Thread.sleep(500);
		System.out.println("In end main " + obj.get());// obj.get (Blocking operation)

		CompletableFuture<Object> obj2 = demo.multi_threaded_CompletableFuture();
		// waiting for completable future to complete;
		Thread.sleep(500);
		System.out.println("In end main " + obj2.get());// obj.get (Blocking operation)

	}

	// Async non-blocking operations -> whole operation executes in single thread

	public CompletableFuture<Object> single_threaded_CompletableFuture() {
		CompletableFuture<Object> obj = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getId());
			return "done";
		}).thenApply((o) -> {
			System.out.println(Thread.currentThread().getId());
			return o;
		}).thenApply((s) -> {
			System.out.println(Thread.currentThread().getId());
			return s;
		});
		return obj;

	}

	// Async non-blocking operations -> each operation can be executed in different
	// thread

	public CompletableFuture<Object> multi_threaded_CompletableFuture() {
		ExecutorService ioBound = Executors.newFixedThreadPool(10);
		ExecutorService cpuBound = Executors.newCachedThreadPool();

		CompletableFuture<Object> obj = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getId());
			return "supplyAsync";
		}, ioBound).thenApplyAsync((o) -> {
			System.out.println(o);
			System.out.println(Thread.currentThread().getId());
			return "First";
		}, cpuBound).thenApplyAsync((s) -> {
			System.out.println(s);
			System.out.println(Thread.currentThread().getId());
			return s;
		}, ioBound);
		return obj;

	}
}
