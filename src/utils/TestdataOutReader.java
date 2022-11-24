package utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class TestdataOutReader {
	
	private static String testdataInFilePath = null;
	private static TestdataOutReader instance = null;
	
	private List<String> lines = null;
	private int ptr = 0;
	
	
	private TestdataOutReader() {
		if (testdataInFilePath == null) {
			throw new IllegalStateException("Not initialized. Please invoke \"init(String testdataInFilePath)\" first.");
		}
		
		try {
			lines = Files.readAllLines(Paths.get(testdataInFilePath), Charset.forName("UTF-8"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public static void init(String testdataInFilePath) {
		TestdataOutReader.testdataInFilePath = testdataInFilePath;
	}
	
	
	public static TestdataOutReader getInstance() {
		if (instance == null) {
			instance = new TestdataOutReader();
		}
		return instance;
	}
	
	
	public String readLine() {
		return lines.get(ptr++);
	}

}
