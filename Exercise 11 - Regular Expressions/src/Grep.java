import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep {
    public static void main(String[] args) throws Exception {

      for (int fileNumber = 1; fileNumber <= 5; fileNumber++) {

        String fileName = "src/TestFile" + fileNumber + ".txt";

        try {

          // Use a File object to open all given text files
          File file = new File(fileName);

          // Use a Scanner object to read the contents of each file
          Scanner scanner = new Scanner(file);

          // Use a while loop to read the file line by line
          while (scanner.hasNextLine()) {
            // Use a Pattern object to compile the regular expression
            Pattern pattern = Pattern.compile("\\d+");

            // Use a Matcher object to match the regular expression with the contents of the file
            String expression = scanner.nextLine();
            Matcher matcher = pattern.matcher(expression);

            // Use a if statement to check if the line contains the regular expression
            if (matcher.find()) {
              // Use a System.out.println() to print the line that contains the regular expression
              System.out.println("File found - " + fileName + ": " + expression);
            }
          }

          scanner.close();

        } catch (FileNotFoundException e) {
          System.out.println("File not found: " + fileName);
          continue;
        }
      }

    }
}
