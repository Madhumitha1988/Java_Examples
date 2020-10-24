package JavaIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class File_Input_demo {
	public static void main(String[] args) throws IOException, ClassNotFoundException, URISyntaxException {
		File_Input_demo demo = new File_Input_demo();
		// demo.fileStreamDemo();
		// demo.fileReaderDemo();
		demo.nioFiles();
	}

	// InputStream reads byte by byte
	public void fileStreamDemo() throws IOException, ClassNotFoundException {
		ClassLoader loader = getClass().getClassLoader();

		URL url = loader.getResource("file.txt");

		System.out.println(url.getFile());

		File f = new File(url.getFile());
		System.out.println(f.exists());

		InputStream isr = new FileInputStream(f);
		StringBuffer buffer = new StringBuffer();

		int i = 0;
		while ((i = isr.read()) != -1) {
			System.out.println(i); // Ascii value of char by char
			buffer.append((char) i);
		}

		isr.close();
		System.out.println(buffer.toString());

	}

	// FileReader reads char by char
	public void fileReaderDemo() throws IOException, ClassNotFoundException {
		ClassLoader loader = getClass().getClassLoader();

		URL url = loader.getResource("file.txt");

		System.out.println(url.getFile());

		File f = new File(url.getFile());
		System.out.println(f.exists());

		FileReader fr = new FileReader(f);
		StringBuffer buffer = new StringBuffer();

		int i = 0;
		while ((i = fr.read()) != -1) {
			System.out.println(i);
			buffer.append((char) i);
		}
		fr.close();
		System.out.println(buffer.toString());

	}

	//Buffered Reader reads line by line
	public void bufferReaderDemo() throws IOException, ClassNotFoundException {
		ClassLoader loader = getClass().getClassLoader();

		URL url = loader.getResource("file.txt");

		System.out.println(url.getFile());

		File f = new File(url.getFile());
		System.out.println(f.exists());

		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		StringBuffer buffer = new StringBuffer();
		String contentLine = br.readLine();
		while (contentLine != null) {
			buffer.append(contentLine);
			buffer.append("\n");

			contentLine = br.readLine();
		}
		br.close();
		System.out.println(buffer.toString());

	}

	//JDK 7 Paths and Files
	public void nioFiles() throws URISyntaxException, IOException {
		ClassLoader loader = getClass().getClassLoader();
		URL url = loader.getResource("file.txt");

		Path path = Paths.get(url.toURI());

		//1->Read all lines
		String read = Files.readAllLines(path).get(0); // This is a test.
		System.out.println(read);

		//2->Buffered reader
		BufferedReader br = Files.newBufferedReader(path);

		StringBuffer buffer = new StringBuffer();
		String contentLine = br.readLine();
		while (contentLine != null) {
			buffer.append(contentLine);
			buffer.append("\n");

			contentLine = br.readLine();
		}
		br.close();
		System.out.println(buffer.toString());


		// 3 -> returns stream
		Files.lines(path).forEach(System.out::println);

		String fileContent=Files.lines(path).collect(Collectors.joining("\n"));
		System.out.println(fileContent);
	}

}
