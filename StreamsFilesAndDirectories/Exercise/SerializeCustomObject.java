package StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException {
        Course course = new Course();
        course.name = "Java Advanced";
        course.studentCount = 250;
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("course.ser"));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("course.ser"))) {
            objectOutputStream.writeObject(course);
            Course course1 = (Course) objectInputStream.readObject();
            System.out.println(course1.name);
            System.out.println(course1.studentCount);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
