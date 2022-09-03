package StreamsFilesAndDirectories.Exercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) throws IOException {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("output.zip"))) {
            File file = new File("C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            Files.copy(file.toPath(), zipOutputStream);
        }
    }
}
