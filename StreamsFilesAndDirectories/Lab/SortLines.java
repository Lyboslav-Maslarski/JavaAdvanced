package StreamsFilesAndDirectories.Lab;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "out.txt";
        List<String> lines = Files.readAllLines(Path.of(path));
        Collections.sort(lines);
        Path write = Files.write(Path.of(output), lines);
    }
}
