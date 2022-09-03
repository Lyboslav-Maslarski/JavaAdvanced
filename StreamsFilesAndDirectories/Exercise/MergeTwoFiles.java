package StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path path2 = Paths.get("C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        Path output = Paths.get("output.txt");
        List<String> file1 = Files.readAllLines(path1);
        List<String> file2 = Files.readAllLines(path2);
        Files.write(output,file1, StandardOpenOption.APPEND);
        Files.write(output,file2,StandardOpenOption.APPEND);
    }
}
