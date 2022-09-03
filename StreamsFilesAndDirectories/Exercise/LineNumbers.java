package StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
             PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"))) {
            String line = bufferedReader.readLine();
            int counter = 1;
            while (line != null) {
                printWriter.println(counter + ". " + line);
                counter++;
                line = bufferedReader.readLine();
            }
        }
    }
}
