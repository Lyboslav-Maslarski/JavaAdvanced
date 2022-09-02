package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        String path = "C:\\Users\\lyb4o\\OneDrive\\Desktop\\04.Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("out.txt");
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                if (oneByte == 10) {
                    fileOutputStream.write(oneByte);
                } else if (oneByte == 32) {
                    fileOutputStream.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        fileOutputStream.write(digits.charAt(i));
                    }
                }
                oneByte = fileInputStream.read();
            }
        } catch (IOException ignored) {
        }
    }
}
