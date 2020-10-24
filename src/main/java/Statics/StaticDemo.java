package Statics;

public class StaticDemo {
	public static void main(String[] args) {
		int counter;
		User u1 = new User("Madhu", 30);
		counter = u1.loginUser();

		System.out.println(u1.getName() + "---" + u1.getAge() + "----" + counter);

		User u2 = new User("Gautam", 35);
		counter = u2.loginUser();

		System.out.println(u2.getName() + "---" + u2.getAge() + "----" + counter);

	}
}

class User {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private String name;
	private int age;

	// static Initialized only once ->First object creation
	// all object share this static variable
	static int counter;

	static {
		counter = 0;
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// All objects share this method . The block is in method memory
	public int loginUser() {
		this.counter++;
		return this.counter;
	}

}
