package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream("out.txt"));
            Scanner scanner = new Scanner(new FileInputStream(path));
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    printWriter.println(scanner.nextInt());
                }
                scanner.next();
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
