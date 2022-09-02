package StreamsFilesAndDirectories.Lab;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "out.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        String line = reader.readLine();
        int counter = 0;
        while (line != null) {
            counter++;
            if (counter % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }
            line = reader.readLine();
        }
        writer.close();
    }
}
