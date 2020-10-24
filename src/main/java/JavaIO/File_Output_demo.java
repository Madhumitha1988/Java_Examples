package JavaIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File_Output_demo {
	public static void main(String[] args) throws IOException {
		File_Output_demo demo = new File_Output_demo();
		File f = demo.createFile();
		demo.file_OutputStream_demo(f);
		demo.fileWriter_demo(f);
		demo.bufferedWriter_demo(f);
		demo.nio2_demo(f);
	}

	public File createFile() throws IOException {

		File f = new File("outputFile.txt");
		boolean created = false;
		if (!f.exists()) {
			created = f.createNewFile();
		}
		System.out.println("Created--- >" + created);
		return f;
	}

	// Write byte by byte
	public void file_OutputStream_demo(File f) throws IOException {
		String content = "This is so cool.\nI love it\n";
		FileOutputStream fos = new FileOutputStream(f);
		byte[] strToBytes = content.getBytes();
		fos.write(strToBytes);
		fos.close();
	}

	// Write char by char
	public void fileWriter_demo(File f) throws IOException {
		FileWriter fw = new FileWriter(f);
		String content = "This is from file writer\n";
		fw.write(content.toCharArray());
		fw.close();
	}
	// Buffered writer writes line by line
	
	public void bufferedWriter_demo(File f) throws IOException {
		FileWriter fw = new FileWriter(f);
		String content = "This is from buffered writer\nIts too cool.";
		BufferedWriter bw =new BufferedWriter(fw);
		bw.write(content);
		bw.close();
	}

	//nio2  -Paths and Files
	
	public void nio2_demo(File f) throws IOException {
		Path path=Paths.get(f.toURI());
		
		String content = "This is from nio2 writer\nIts too cool.";

		//Write byte by byte
		Files.write(path, content.getBytes());
		
		//Buffers and write whole content
		BufferedWriter bw =Files.newBufferedWriter(path);
		bw.write(content);
	}
	
	
}
