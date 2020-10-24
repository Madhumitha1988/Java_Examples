package JavaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BufferReader_demo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter no ::");
		int i =Integer.parseInt(br.readLine());
		
		System.out.println("Integer -- >"+i);
		
		
	}

}
