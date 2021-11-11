import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// check if file exists
		File file = new File("ls-output.txt");
		if (!file.exists()) {
			System.out.println("File Does not exist");
			System.exit(0);
		}

		
		// take string from user to search
		String wordToSearch = getStringInput();

		
		// search in file, line by line
		try {
			FileReader fileReaderObj = new FileReader(file);
			BufferedReader bufferedReaderObj = new BufferedReader(fileReaderObj);
			String lineFromBuffer = bufferedReaderObj.readLine();
			boolean isWordFound = false; 
			while (lineFromBuffer != null) {
				if (lineFromBuffer.contains(wordToSearch)) {
					int indexOfWordInFile = lineFromBuffer.indexOf(wordToSearch);
					System.out.println(wordToSearch + " found at index:" +indexOfWordInFile );
					printTheLineFound(indexOfWordInFile,lineFromBuffer);
					isWordFound = true;
					break;
				}
				lineFromBuffer = bufferedReaderObj.readLine();
			}
			if (!isWordFound) {
				System.out.println("Word doesn't exist in this file");
			}

			fileReaderObj.close();
			bufferedReaderObj.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error:File not Found, file name = " + file.getName());
		} catch (IOException e) {
			System.out.println("Error:Read from file failed, file name = " + file.getName());
			e.printStackTrace();
		} 
	}

	public static String getStringInput() {
		try (Scanner input = new Scanner(System.in);) {
			System.out.println("Enter a word to search");
			return input.next();
		}

	}
	
	public static void printTheLineFound(int index, String str) {
		System.out.println(str);
		for(int i = 0; i < index ; i++) 
			System.out.print(" ");
		System.out.println("^");
	}

}
