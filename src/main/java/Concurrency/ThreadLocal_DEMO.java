package Concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;

//Returns copy of of object to each thread.
public class ThreadLocal_DEMO {

	public static void main(String[] args) {
		ThreadLocal_DEMO demo = new ThreadLocal_DEMO();
		String dateFormatted=demo.birthDate();
		System.out.println("In main thread d->"+dateFormatted);
		
		Thread t1= new Thread(new Task3());
		t1.start();
	}

	public String birthDate() {
		Date bday= new Date();
		final SimpleDateFormat df=ThreadSafeFomatter.dateFormatter.get();
		return df.format(bday);
	}
}

class ThreadSafeFomatter {
	public static ThreadLocal<SimpleDateFormat> dateFormatter = ThreadLocal.withInitial(() -> {
		System.out.println("Each thread gets a copy of this formatter");
		return new SimpleDateFormat("yyyy-mm-dd");
	});
}
class Task3 implements Runnable {

	@Override
	public void run() {
		Date bday= new Date();
		final SimpleDateFormat df=ThreadSafeFomatter.dateFormatter.get();
		String d= df.format(bday);
		System.out.println("In Task1 day ->"+d);
	
	}

}
