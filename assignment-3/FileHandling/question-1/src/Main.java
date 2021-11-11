import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    File file = new File("ls-output.txt");
    if (!file.exists()) {
      System.out.println("File Does not exist");
      System.exit(0);
    }

    // store the buffered reader content in a string
    String fileContent = null;
    try {
      FileReader fileReaderObj = new FileReader(file);
      BufferedReader bufferedReaderObj = new BufferedReader(fileReaderObj);

      String buffereReaderContent = bufferedReaderObj.readLine();
      fileContent = buffereReaderContent + "\n";

      while (true) {
        buffereReaderContent = bufferedReaderObj.readLine();
        if (buffereReaderContent == null) break;
        fileContent = fileContent + buffereReaderContent + "\n";
      }

      System.out.println(fileContent);
      fileReaderObj.close();
      bufferedReaderObj.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error:File not Found, file name = " + file.getName());
    } catch (IOException e) {
      System.out.println(
        "Error:Read from file failed, file name = " + file.getName()
      );
    } finally {
      System.out.println(
        "Number of Characters: " + getNumberOfCharacters(fileContent)
      );
      System.out.println("Number of Words :" + getNumberOfWords(fileContent));
      System.out.println("Number of Lines :" + getNumberOfLines(fileContent));
    }
  }

  public static int getNumberOfCharacters(String fileContents) {
    return fileContents.length();
  }

  public static int getNumberOfWords(String fileContent) {
    // to do - make both regex on one line
    fileContent = fileContent.replaceAll("\n", " ");
    fileContent = fileContent.replaceAll("\\s{2,}", " ");

    return fileContent.split(" ").length;
  }

  public static int getNumberOfLines(String fileContent) {
    return fileContent.split("\n").length;
  }
}
