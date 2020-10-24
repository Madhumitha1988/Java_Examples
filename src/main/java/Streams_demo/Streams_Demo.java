package Streams_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams_Demo {

	public static void main(String[] args) {
		int[] a = new int[10];
		Arrays.fill(a, 0, 10, 100);

		System.out.println("********************* Stream Initialization *********************************");

		IntStream ins = Arrays.stream(a);

		Stream<String> str_stream = Stream.<String>builder().add("a").add("b").add("c").build();

		Stream<String> str_stream2 = Stream.generate(() -> {
			return "hello";
		}).limit(10);

		Stream<Integer> itr_Stream = Stream.iterate(40, n -> n + 2).limit(5);
		Stream<Double> dos = Stream.of(1.3, 2.4, 3.0);

		IntStream primitive_Stream = IntStream.range(1, 3); // Stream<int> is not there
		
		Stream<Integer> itr_stream2 = primitive_Stream.boxed();

		System.out.println("********************* Reduce Function *********************************");

		Double value = dos.reduce(0.0, (acc, val) -> {
			System.out.println("ACC ->" + acc);
			System.out.println("Val ->" + val);

			return acc + val;
		});

		Stream<Double> dos1 = Stream.of(1.3, 2.4, 3.0);

		Optional<Double> value1 = dos1.reduce((acc, val) -> {
			return acc + val;
		});

		System.out.println("Value-->" + value);
		System.out.println("Value-->" + value1.get());

		Stream<Integer> itr_str2 = Stream.iterate(10, n -> n + 1).limit(10);

		int val_reduced = itr_str2.parallel().reduce(0, (acc, val) -> {
			return val + acc;
		}, (acc, val) -> {
			System.out.println("Combiner called");
			return acc + val;
		});

		/*
		 * reducer -> parallel result 11+0 ,12+0,13+0 .. combiner-> 11+12 , 23+13 .....
		 */

		System.out.println("Value-->" + val_reduced);

		System.out.println("********************* Foreach and Parallel Streams *********************************");

		ArrayList<String> list = new ArrayList<>();
		list.add("hello");
		list.add("bye");
		list.add("Madhu");
		list.add("Vivaan");

		list.stream().forEach(System.out::println);

		list.parallelStream().forEach(System.out::println);

		System.out.println("******************** Match ***********************************");

		System.out.println(list.stream().anyMatch(el -> el.contains("a"))); // true
		System.out.println(list.stream().allMatch(el -> el.contains("a"))); // true
		System.out.println(list.stream().noneMatch(el -> el.contains("a"))); // true

		System.out.println("********************* Filter **********************************");

		// Intermediate operations like filter,map are lazy , They ll not be invoked
		// unless we call a terminal operation (forEach,collect,count)

		list.stream().filter(el -> el.contains("a")).forEach(System.out::println);

		System.out.println("********************* Map **********************************");

		list.stream().map(String::toUpperCase).forEach(System.out::println);

		System.out.println("****************** FlatMap *************************************");

		Function<String, Stream<String>> function = str -> {
			return Stream.of(str);
		};

		list.stream().flatMap(function).forEach(System.out::println);

		System.out.println("****************** Collectors *************************************");

		Stream<Integer> collect_str = Stream.iterate(10, n -> n + 1).limit(10);

		List<String> list2 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
		
		String list_str = list.stream().collect(Collectors.joining(", "));
		System.out.println(list_str);

		List unModifiableList= collect_str.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

		//unModifiableList.add(100); Exception is thrown if we modify unModifioable list
	} 

}
