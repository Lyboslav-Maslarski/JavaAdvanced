package StreamsFilesAndDirectories.Exercise;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"))) {
            Path path1 = Path.of("C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
            Scanner scanner = new Scanner(new FileReader("C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
            Map<String, Integer> occurrences = new LinkedHashMap<>();
            Arrays.stream(Files.readString(path1).split("\\s+")).toList().forEach(s -> occurrences.put(s, 0));
            while (scanner.hasNext()) {
                String next = scanner.next();
                if (occurrences.containsKey(next)) {
                    occurrences.put(next, occurrences.get(next) + 1);
                }
            }
            occurrences.entrySet().stream().sorted(Comparator.comparingInt(e -> -e.getValue())).forEach(e -> printWriter.println(e.getKey() + " - " + e.getValue()));
        }
    }
}
