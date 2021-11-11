import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    // check if arguments are passed
    if (args.length != 2) {
      System.out.println("java Main source target ");
      System.exit(1);
    }
    // Read source and destination file from the user as an argument
    String sourceFileName = args[0];
    String targetFileName = args[1];

    // check if source and target file exists
    File source = new File(sourceFileName);
    File target = new File(targetFileName);
    if (!source.exists()) {
      System.out.println("Source file doesn't exist");
      System.exit(1);
    }
    if (!target.exists()) {
      System.out.println("Target file doesn't exist");
      System.exit(1);
    }

    // copy the contents
    try {
      cp(source, target);
    } catch (FileNotFoundException e) {
      System.out.println(
        "the source or target file does not exist or is a directory"
      );
    } catch (IOException e) {
      System.out.println("I/O error occured");
    }
  }

  public static void cp(File source, File target) throws IOException {
    try (
      FileReader fileReaderObj = new FileReader(source);
      FileWriter fileWriterObj = new FileWriter(target);
      BufferedReader bufferedReaderObj = new BufferedReader(fileReaderObj);
      BufferedWriter bufferedWriterObj = new BufferedWriter(fileWriterObj);
    ) {
      String lineFromBuffer = bufferedReaderObj.readLine();
      String copyOfLineFromBuffer = null;
      int numberOfLines = 0;
      while (lineFromBuffer != null) {
        copyOfLineFromBuffer = lineFromBuffer + "\n";
        bufferedWriterObj.write(copyOfLineFromBuffer);
        numberOfLines += 1;
        lineFromBuffer = bufferedReaderObj.readLine();
      }
      System.out.println(numberOfLines + " lines copied.");
    }
  }
}
