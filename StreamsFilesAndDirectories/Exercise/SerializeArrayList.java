package StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) throws IOException {
        List<Double> list = List.of(2.0, 4.2, 5.4);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("list.ser"));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("list.ser"))) {
            objectOutputStream.writeObject(list);
            List<Double> list1 = (List<Double>) objectInputStream.readObject();
            System.out.println(list1);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
