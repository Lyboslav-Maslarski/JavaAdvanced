package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NestedFolders {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        List<File> fileList = Files.walk(file.toPath()).map(Path::toFile).filter(File::isDirectory).collect(Collectors.toList());
        System.out.println(Files.walk(file.toPath()).map(Path::toFile).filter(File::isDirectory).map(File::getName).collect(Collectors.joining(System.lineSeparator())));
        System.out.println(fileList.size()+" folders");
    }
}
