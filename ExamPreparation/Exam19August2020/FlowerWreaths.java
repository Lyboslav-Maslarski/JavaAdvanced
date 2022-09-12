package ExamPreparation.Exam19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int flowerWreaths = 0;
        int storage = 0;
        List<Integer> firstLine = Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondLine = Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> roses = new ArrayDeque<>();
        ArrayDeque<Integer> lilies = new ArrayDeque<>();

        firstLine.forEach(lilies::push);
        secondLine.forEach(roses::offer);

        while (!roses.isEmpty() && !lilies.isEmpty()) {
            int rose = roses.poll();
            int lily = lilies.pop();
            int sum = rose + lily;
            if (sum == 15) {
                flowerWreaths++;
            } else if (sum > 15) {
                while (sum > 15) {
                    lily -= 2;
                    sum = rose + lily;
                    if (sum == 15) {
                        flowerWreaths++;
                    } else if (sum < 15) {
                        storage += rose;
                        storage += lily;
                    }
                }
            } else {
                storage += rose;
                storage += lily;
            }
        }

        if (storage != 0) {
            int storedWreaths = storage / 15;
            flowerWreaths += storedWreaths;
        }

        if (flowerWreaths >= 5) {
            System.out.println("You made it, you are going to the competition with " + flowerWreaths + " wreaths!");
        } else {
            System.out.println("You didn't make it, you need " + (5 - flowerWreaths) + " wreaths more!");
        }
    }
}
