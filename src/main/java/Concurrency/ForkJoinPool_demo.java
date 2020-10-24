package Concurrency;

import java.util.concurrent.RecursiveTask;

//There is queue for all tasks and also queue for each thread (subtasks)
//Each subtasks can be executed by same thread or free thread with no tasks

//fork to split task to subtasks
//join to join all suntasks

public class ForkJoinPool_demo {
	public static void main(String[] args) {
		Fibanocci fibObj = new Fibanocci(8);
		System.out.println(fibObj.compute());
	}
}

class Fibanocci extends RecursiveTask<Integer> {
	final int n;

	Fibanocci(int n) {
		this.n = n;
	}

	public int fib() {
		if (n <= 1) {
			return n;
		} else {
			Fibanocci f1 = new Fibanocci(n - 1);

			Fibanocci f2 = new Fibanocci(n - 2);

			return f1.fib() + f2.fib();
		}

	}

	@Override
	protected Integer compute() {
		if (n <= 1) {
			return n;
		} else {
			Fibanocci f1 = new Fibanocci(n - 1);
			f1.fork();  //splits task to subtasks

			Fibanocci f2 = new Fibanocci(n - 2);
			f2.fork();

			return f1.join() + f2.join();
		}

	}

}
