package Arrays_Demo;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Arrays_demo {

	public static void main(String[] args) {
		Arrays_demo object = new Arrays_demo();
		object.varArgsMethod("hello", "bye", "goodnight");

	}

	void varArgsMethod(String... varargs) {
		//Variable no of arguments
		Stream<String> str2 = Arrays.stream(varargs);
		str2.filter(s -> {
			return s.equals("hello");
		}).forEach(System.out::println);

		
		//Array Declarations
		int[] array = new int[10];
		int[] array2 = new int[] { 3, 5, 8, 4, 9 };

		
		//QuickSort is used for sorting
		Arrays.sort(array2);
		
		
		//IntStream for int array
		IntStream str = Arrays.stream(array2);
		str.forEach(s -> {
			System.out.println(s);
		});


		//Binary search O(log n) 
		//Linear Search O(n)
		System.out.println("Str found Index --"+Arrays.binarySearch(array2, 5));
		
		
		

	}

}
