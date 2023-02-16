package ExamPreparation.Exam22October2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> caffeineValues = new ArrayDeque<>();
        Deque<Integer> energyDrinksValues = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(caffeineValues::push);
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(energyDrinksValues::offer);

        int caffeineMg = 0;
        int limit = 300;

        while (!caffeineValues.isEmpty() && !energyDrinksValues.isEmpty()) {
            int caffeine = caffeineValues.pop();
            int energyDrink = energyDrinksValues.poll();

            int result = caffeine * energyDrink;

            if (result <= limit) {
                caffeineMg += result;
                limit -= result;
            } else {
                energyDrinksValues.offer(energyDrink);
                caffeineMg = Math.max(0, caffeineMg - 30);
                limit = Math.min(300, limit + 30);
            }

        }

        if (energyDrinksValues.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            System.out.println("Drinks left: " + energyDrinksValues.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println("Stamat is going to sleep with " + caffeineMg + " mg caffeine.");
    }
}
