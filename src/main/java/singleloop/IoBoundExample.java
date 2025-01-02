package singleloop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IoBoundExample {

	public static void main(String[] args) {
		IoBoundExample ioBoundExample = new IoBoundExample();
		ioBoundExample.action();
	}

	 public void action() {
		coreTask();
	 }

	private static void coreTask() {
		String sourceFile = "source.txt";
		String destinationFile = "destination.txt";

		// Create a sample file for testing
		createSampleFile(sourceFile);

		// Perform the file copy operation
		copyFile(sourceFile, destinationFile);

	}

	private static void copyFile(String source, String destination) {
		try (BufferedReader reader = new BufferedReader(new FileReader(source));
			BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {

			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}

		} catch (IOException e) {
			System.err.println("Error during file copy: " + e.getMessage());
		}
	}

	private static void createSampleFile(String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (int i = 0; i < 10000000; i++) {
				writer.write("This is line " + i);
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.println("Error creating sample file: " + e.getMessage());
		}
	}
}
