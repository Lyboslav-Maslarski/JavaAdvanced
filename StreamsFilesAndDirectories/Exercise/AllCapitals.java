package StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\lyb4o\\OneDrive\\Desktop\\" +
                                                                          "04.Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        String line = bufferedReader.readLine();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        while (line != null) {
            bufferedWriter.write(line.toUpperCase());
            bufferedWriter.newLine();
            line = bufferedReader.readLine();
        }
        bufferedWriter.close();
    }
}
