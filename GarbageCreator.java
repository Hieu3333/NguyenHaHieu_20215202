package p;

import java.nio.file.*;
import java.io.IOException;

public class GarbageCreator {

	public static void main(String[] args) {
		String filename = "C:\\Users\\PC\\Downloads\\octave-8.1.0-w64-installer.exe";
		byte[] inputBytes = { 0 };
		long startTime, endTime;
		
		try {
		inputBytes = Files.readAllBytes(Paths.get(filename));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		startTime = System.currentTimeMillis();
		String outputString ="";
		
		for (byte b : inputBytes) {
			outputString += (char)b;
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		

	}

}
