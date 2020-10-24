package Collections;

import java.util.HashSet;

public class HastSet_Demo {

	public static void main(String[] args) {
		// Internally hashset is a hashmap with only key values
		// HashSet has only unique values

		HashSet<String> set = new HashSet<String>();
		set.add("hello");
		set.add("hello");

		set.add("bye");

		System.out.println(set.size());

	}

}
