package comparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class comparator_demo {
	public static void main(String[] args) {
		Player1 p1 = new Player1("Madhu", 1, 30);
		Player1 p2 = new Player1("Gautam", 3, 30);
		Player1 p3 = new Player1("Vivaan", 2, 6);
		Player1 p4 = new Player1("Sammu", 4, 6);

		ArrayList<Player1> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		Comparator Player1AgeCompatator=new Player1AgeCompatator();
		Collections.sort(list,Player1AgeCompatator);
		
		Arrays.stream(list.toArray()).forEach(item->{
			Player1 p=(Player1)item;
			System.out.println(p.getName());
		});


	}
}


class Player1RankCompatator implements Comparator<Player1>{

	@Override
	public int compare(Player1 o1, Player1 o2) {
		// TODO Auto-generated method stub
		return o1.getRank()-o2.getRank();
	}
	
}
class Player1AgeCompatator implements Comparator<Player1>{

	@Override
	public int compare(Player1 o1, Player1 o2) {
		// TODO Auto-generated method stub
		return o1.getAge()-o2.getAge();
	}
	
}


class Player1{
	private int rank;
	private int age;
	private String name;

	Player1(String name, int rank, int age) {
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

}