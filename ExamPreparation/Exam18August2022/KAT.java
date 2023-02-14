package ExamPreparation.Exam18August2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class KAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> plates = new ArrayDeque<>();
        Deque<Integer> cars = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(plates::offer);
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(cars::push);

        int countCarsRegistered = 0;
        int days = 0;
        while (!plates.isEmpty() && !cars.isEmpty()) {
            days++;
            int currentDayPlates = plates.poll();
            int currentDayCars = cars.pop();

            int carRegistered = currentDayPlates / 2;

            if (carRegistered == currentDayCars) {
                countCarsRegistered += carRegistered;
            } else if (carRegistered > currentDayCars) {
                countCarsRegistered += currentDayCars;
                int leftPlates = currentDayPlates - (currentDayCars * 2);
                plates.offer(leftPlates);
            } else {
                countCarsRegistered += currentDayPlates / 2;
                int leftCars = currentDayCars - (currentDayPlates / 2);
                cars.offer(leftCars);
            }

        }

        System.out.printf("%d cars were registered for %d days!%n", countCarsRegistered, days);
        if (!cars.isEmpty()) {
            System.out.println(cars.stream().mapToInt(Integer::intValue).sum() + " cars remain without license plates!");
        } else if (!plates.isEmpty()) {
            System.out.println(plates.stream().mapToInt(Integer::intValue).sum() + " license plates remain!");
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }

    }
}
