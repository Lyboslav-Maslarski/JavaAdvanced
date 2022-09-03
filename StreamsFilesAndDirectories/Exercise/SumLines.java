package StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        String line = bufferedReader.readLine();
        while (line != null) {
            long sum = 0L;
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }
            System.out.println(sum);
            line = bufferedReader.readLine();
        }
    }
}
