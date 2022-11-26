package ExamPreparation.Exam22Feb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> firstLootBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(secondLootBox::push);
        int loot = 0;

        while (!firstLootBox.isEmpty() && !secondLootBox.isEmpty()) {
            Integer firstLoot = firstLootBox.peek();
            Integer secondLoot = secondLootBox.pop();

            int sum = firstLoot + secondLoot;
            if (sum % 2 == 0) {
                loot += sum;
                firstLootBox.poll();
            } else {
                firstLootBox.offer(secondLoot);
            }
        }

        if (firstLootBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (loot >= 100) {
            System.out.println("Your loot was epic! Value: " + loot);
        } else {
            System.out.println("Your loot was poor... Value: " + loot);
        }
    }
}
