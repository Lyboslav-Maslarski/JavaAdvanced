package ExamPreparation.Exam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bouquets = 0;
        int leftFlowers = 0;
        Deque<Integer> tulips = new ArrayDeque<>();
        Deque<Integer> daffodils = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(tulips::push);
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(daffodils::offer);

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            Integer daffodil = daffodils.poll();
            Integer tulip = tulips.pop();

            int sum = daffodil + tulip;

            while (sum > 15) {
                sum -= 2;
            }

            if (sum == 15) {
                bouquets++;
            }
            if (sum < 15) {
                leftFlowers += sum;
            }
        }
        if (leftFlowers >= 15) {
            bouquets += (leftFlowers / 15);
        }
        if (bouquets >= 5) {
            System.out.println("You made it! You go to the competition with " + bouquets + " bouquets!");
        } else {
            System.out.println("You failed... You need more " + (5 - bouquets) + " bouquets.");
        }
    }
}
