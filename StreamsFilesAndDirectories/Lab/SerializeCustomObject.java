package StreamsFilesAndDirectories.Lab;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeCustomObject {
    private static class Cube implements Serializable {
        String color;
        double width;
        double height;
        double depth;
    }

    public static void main(String[] args) throws IOException {
        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3;
        cube.height = 12.4;
        cube.depth = 3;
        String output = "out.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(output));
        objectOutputStream.writeObject(cube);
    }
}
