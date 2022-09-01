package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, double[]> studentsWithGrades = new TreeMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            double[] grades = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            studentsWithGrades.putIfAbsent(name, grades);
        }
        for (Map.Entry<String, double[]> entry : studentsWithGrades.entrySet()) {
            System.out.printf("%s is graduated with ", entry.getKey());
            double sumGrades = 0;
            for (double grade : entry.getValue()) {
                sumGrades += grade;
            }
            System.out.print(sumGrades / entry.getValue().length);
            System.out.println();
        }
    }
}
