package comparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Comparable_demo {

	public static void main(String[] args) {
		Player p1 = new Player("Madhu", 1, 30);
		Player p2 = new Player("Gautam", 3, 30);
		Player p3 = new Player("Vivaan", 2, 6);
		Player p4 = new Player("Sammu", 4, 6);

		ArrayList<Player> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		Collections.sort(list);

		Arrays.stream(list.toArray()).forEach(item->{
			Player p=(Player)item;
			System.out.println(p.getName());
		});

	}

}

class Player implements Comparable<Player> {
	private int rank;
	private int age;
	private String name;

	Player(String name, int rank, int age) {
		this.name = name;
		this.age = age;
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override//small to big
	public int compareTo(Player obj) {
		return this.getRank() - obj.getRank();
	}

}
