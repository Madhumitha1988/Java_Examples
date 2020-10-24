package Generics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;




//PRIMITIVE TYPES DOESN'T WORK WITH GENERICS



public class Generic_demo<R> {
	public <T> List<T> fromArrayToList(T[] a) {

		// Arrays.asList(a);
		return Arrays.stream(a).collect(Collectors.toList());
	}

	
	public <T> void printArray(T[] a) {
		Arrays.stream(a).forEach(System.out::println);
	}

	public <T, G extends Function<T, R>> List<R> fromArrayToList(T[] a, G mapperFn) {

		return (List<R>) Arrays.stream(a).map(mapperFn).collect(Collectors.toList());
	}
	
	
	public <T, G extends Function<T, R>> List<? extends Object> fromArrayToListWildCard(T[] a, G mapperFn) {

		return (List<R>) Arrays.stream(a).map(mapperFn).collect(Collectors.toList());
	}
	
	


	public static void main(String[] args) {
		Generic_demo demo = new Generic_demo();
		Integer[] a = new Integer[10];
		Arrays.fill(a, 0, 10, 10);
		
		demo.printArray(a);
		
		List<Integer> arr = demo.fromArrayToList(a);
		
		
		Function<Integer, String> fn1= (val)->{return val.toString()+"hurray!!";};
		
		List<String> arr_str=demo.fromArrayToList(a,fn1);
		System.out.println(arr_str.get(1));
		
		
		List<String> arr_str2=demo.fromArrayToListWildCard(a,fn1);
		System.out.println(arr_str2.get(3));
		
		
	}

}
