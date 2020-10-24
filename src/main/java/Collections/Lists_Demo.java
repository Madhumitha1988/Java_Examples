package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lists_Demo {
	List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		Lists_Demo demo = new Lists_Demo();
		demo.list.add(5);
		demo.list.add(8);
		demo.list.add(25);
		demo.list.add(2);
		Iterator<Integer> itr = demo.list.iterator();
		while (itr.hasNext()) {
			 System.out.println(itr.next());
		}
		// Lists
		List<Integer> str_List = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
		Object[] str_array = str_List.toArray();

		System.out.println(str_List.get(5));

		// Linked Lists

		System.out.println("linked start");

		LinkedList<Integer> linkList = new LinkedList<>();
		linkList.add(20);
		linkList.addAll(str_List);
		linkList.addFirst(100);
		linkList.addLast(200);

		Iterator<Integer> itre2 = linkList.iterator();

		System.out.println("First--->" + linkList.getFirst());
		System.out.println(linkList.get(0));
		System.out.println(linkList.get(1));

		System.out.println(linkList.getLast());

		while (itre2.hasNext()) {
			System.out.println(itre2.next());
		}
		
		
		
	}

}
