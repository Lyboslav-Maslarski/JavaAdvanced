package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.util.Arrays;

public class ListFiles {
    public static void main(String[] args) {
        String path = "C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        String output = "out.txt";
        File file=new File("C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        Arrays.stream(file.listFiles()).filter(File::isFile).forEach(f -> System.out.println(f.getName()+": ["+f.length()+"]"));
    }
}
