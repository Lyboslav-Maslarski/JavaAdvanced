package StreamsFilesAndDirectories.Exercise;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024];
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\lyb4o\\OneDrive\\Desktop\\20181019_173119.jpg");
             FileOutputStream fileOutputStream = new FileOutputStream("copy.jpg")) {
            while (fileInputStream.read(bytes) != -1) {
                fileOutputStream.write(bytes);
            }
        }

    }
}
