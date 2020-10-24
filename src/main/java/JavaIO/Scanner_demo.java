package JavaIO;

import java.util.Scanner;

public class Scanner_demo {
	public static void main(String[] args) {
		
		Scanner scan =new Scanner(System.in);
		
		System.out.print("Enter name ::" );
		String name = scan.nextLine();
		System.out.print("Enter age ::" );
		int age=scan.nextInt();
		
		System.out.println(name + " " +age);
		
		while(scan.hasNext()) {
			int num = scan.nextInt();
			System.out.println(num);

		}
		
	}
	

}
