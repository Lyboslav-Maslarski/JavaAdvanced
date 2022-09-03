package StreamsFilesAndDirectories.Exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {
        File folder = new File("C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
        Deque<File> files = new ArrayDeque<>();
        files.offer(folder);
        int totalSize = 0;
        while (!files.isEmpty()) {
            File currentFile = files.poll();
            File[] nestedFiles = currentFile.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    files.offer(nestedFile);
                } else {
                    totalSize += nestedFiles.length;
                }
            }
        }
        System.out.println("Folder size: " + totalSize);
    }
}
