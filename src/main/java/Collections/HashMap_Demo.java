package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class HashMap_Demo {
	public static void main(String[] args) {
		HashMap<User, ArrayList<String>> hm = new HashMap<>();

		User u1 = new User("Madhu", 30);
		User u2 = new User("Madhu", 30);
		User u3 = new User("Vivaan", 5);

		addInMap(u1, "madhu_30_1", hm);
		addInMap(u2, "madhu_30_2", hm);
		addInMap(u3, "vivaan_5", hm);

		System.out.println("size-->" + hm.size());
		
		User u4 = new User("Madhu", 30);

		ArrayList<String> val1=hm.get(u4);
		
		Arrays.stream(val1.toArray()).forEach(System.out::println);
		
	}

	public static <T, R> HashMap<T, ArrayList<R>> addInMap(T key, R val, HashMap<T, ArrayList<R>> map) {
		ArrayList<R> list = new ArrayList<>();

		if (map.containsKey(key)) {
			list.addAll((ArrayList) map.get(key));
			list.add(val);

		} else {
			list.add(val);
		}
		map.put(key, list);

		return map;

	}
}

class User {
	private String name;
	private int age;

	User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || o.getClass() != getClass()) {
			return false;
		}
		User obj = (User) o;
		if (obj.name == this.name && obj.age == this.age) {
			return true;
		}
		return false;
	}

}
