package Classes;

import java.lang.reflect.InvocationTargetException;

public class initializers {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Blocks b = new Blocks();

		System.out.println("I is -->" + b.i);
		System.out.println("J is -->" + b.j);

		Reflection_Ex reflection = Reflection_Ex.class.getConstructor().newInstance();

		System.out.println("reflection val-->" + reflection.getText());
	}
}

class Blocks {

	int i;
	{
		i = 50;
	}

	static String j;
	static {
		j = "Hello from block";
	}

}
