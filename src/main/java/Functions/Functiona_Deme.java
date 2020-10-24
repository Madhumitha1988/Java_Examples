package Functions;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Functiona_Deme {
	public static void main(String[] args) {

		// f1 -> first
		// f2->second
		// compose function

		Function<Integer, String> f1 = Object::toString;
		Function<String, String> f2 = s -> " *" + s + "*";
		Function<Integer, String> composeFn = f2.compose(f1);

		Stream<Integer> stream = Stream.iterate(10, n -> n + 1).limit(5);
		stream.map(composeFn).forEach(System.out::println);

		// call a function
		String ans = composeFn.apply(30);
		System.out.println(ans);

		// Using Functional interface
		ShortToByteFn shToBy = sh -> (Byte) sh.byteValue();
		Short[] array = new Short[] { 23, 56, 85, 12 };
		Functiona_Deme demo = new Functiona_Deme();
		Byte[] trans = demo.transformed(array, shToBy);

		System.out.println(trans[0]);

		// Supplier,Consumer and Predicates
		Consumer<Integer> consumer = (val) -> {
			System.out.println(val);
		};
		Supplier<Integer> supplier = () -> {
			return 5;
		};
		Predicate<String> predicate = (str) -> {
			return str.endsWith("a");
		};

	}

	public Byte[] transformed(Short[] array, ShortToByteFn shToBy) {
		// WE DONT HAVE SHORT ARRAY STREAM

		Byte[] transformedArary = new Byte[array.length];

		for (int i = 0; i < array.length; i++) {
			transformedArary[i] = shToBy.applyAsByte(array[i]);
		}

		return transformedArary;

	}
}
