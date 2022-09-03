package StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        String line = bufferedReader.readLine();
        long sum = 0L;
        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }
            line = bufferedReader.readLine();
        }
        System.out.println(sum);
    }
}
