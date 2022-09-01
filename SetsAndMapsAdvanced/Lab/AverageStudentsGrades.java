package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Double>> studentsWithGrades = new TreeMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String student = data[0];
            double grade = Double.parseDouble(data[1]);
            studentsWithGrades.putIfAbsent(student, new ArrayList<>());
            studentsWithGrades.get(student).add(grade);
        }
        for (Map.Entry<String, List<Double>> entry : studentsWithGrades.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());
            double sumGrades = 0;
            for (Double grade : entry.getValue()) {
                System.out.printf("%.2f ", grade);
                sumGrades += grade;
            }
            System.out.printf("(avg: %.2f)%n", sumGrades / entry.getValue().size());
        }
    }
}
