package ExamPreparation.Exam26October2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> males = new ArrayDeque<>();
        Deque<Integer> females = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(males::push);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(females::offer);

        int matches = 0;
        while (!males.isEmpty() && !females.isEmpty()) {
            int male = males.peek();
            int female = females.peek();

            if (male <= 0) {
                males.pop();
                continue;
            }
            if (female <= 0) {
                females.poll();
                continue;
            }

            if (male % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }
            if (female % 25 == 0) {
                females.poll();
                females.poll();
                continue;
            }

            if (male == female) {
                males.pop();
                females.poll();
                matches++;
            } else {
                females.poll();
                males.pop();
                males.push(male - 2);
            }
        }
        System.out.println("Matches: " + matches);
        System.out.println("Males left: "+(males.isEmpty()?"none":males.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        System.out.println("Females left: "+(females.isEmpty()?"none":females.stream().map(String::valueOf).collect(Collectors.joining(", "))));
    }
}
