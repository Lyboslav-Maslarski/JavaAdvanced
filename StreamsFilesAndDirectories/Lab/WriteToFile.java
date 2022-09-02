package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        Set<Character> punctuation = Set.of(',', '.', '?', '!');
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            FileOutputStream fileOutputStream = new FileOutputStream("out.txt");


            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                if (!punctuation.contains((char) oneByte)) {
                    fileOutputStream.write(oneByte);
                }
                oneByte = fileInputStream.read();
            }
        } catch (IOException ignored) {
        }
    }
}
