package JavaIO;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console_demo {

	public static void main(String[] args) throws IOException {
		Console console = System.console();

		if (console != null) {
			String userName = console.readLine("Enter Username ::");
			char[] pwd = console.readPassword("Enter pwd ::");

			System.out.println(userName + " " + pwd);
		}
		else {
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter userNamer::");
			String  username =br.readLine();
			System.out.println("Enter pwd::");
			String  pwd =br.readLine();

			
			System.out.println(username + " " + pwd);
		
		}

	}

}
