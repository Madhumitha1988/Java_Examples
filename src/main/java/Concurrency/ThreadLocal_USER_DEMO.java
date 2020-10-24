package Concurrency;

public class ThreadLocal_USER_DEMO {
	public static void main(String[] args) {
		Service1 ser1= new Service1();
		Service2 ser2= new Service2();
		Service3 ser3= new Service3();
		
		
		System.out.println("Before ser1 user-->"+ UserContextHolder.user.get());
		ser1.process();
		ser2.process();
		ser3.process();
		System.out.println("After ser3 user-->"+ UserContextHolder.user.get());

	}

}

class User {
	String name;
	int age;

	User(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

//Thread safe User object , No synchronization required to modify it. Each thread can get a copy of it.
//Instead of padding object b/w servie1 and service 2 ; we can access it from here.

class UserContextHolder {
	public static ThreadLocal<User> user = new ThreadLocal<User>();
}

class Service1 {
	public void process() {
		User user = new User("Madhu", 30);
		UserContextHolder.user.set(user);
	}
}

class Service2 {
	public void process() {
		User user = UserContextHolder.user.get();
		System.out.println("User name ->"+user.name);

	}
}

class Service3 {
	public void process() {
		UserContextHolder.user.remove();;

	}

}
