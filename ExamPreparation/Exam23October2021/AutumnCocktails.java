package ExamPreparation.Exam23October2021;

import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Apple Hinny", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Pear Sour", 0);
        cocktails.put("High Fashion", 0);
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessLevels = new ArrayDeque<>();
        for (int i : firstLine) {
            ingredients.offer(i);
        }
        for (int i : secondLine) {
            freshnessLevels.push(i);
        }
        while (!ingredients.isEmpty() && !freshnessLevels.isEmpty()) {
            int ingredient = ingredients.poll();
            if (ingredient == 0) {
                continue;
            }
            int freshnessLevel = freshnessLevels.pop();
            int mix = ingredient * freshnessLevel;
            if (mix == 150) {
                int value = cocktails.get("Pear Sour");
                cocktails.put("Pear Sour", value + 1);
            } else if (mix == 250) {
                int value = cocktails.get("The Harvest");
                cocktails.put("The Harvest", value + 1);
            } else if (mix == 300) {
                int value = cocktails.get("Apple Hinny");
                cocktails.put("Apple Hinny", value + 1);
            } else if (mix == 400) {
                int value = cocktails.get("High Fashion");
                cocktails.put("High Fashion", value + 1);
            } else {
                ingredients.offer(ingredient + 5);
            }
        }
        boolean haveMadeAllCocktails = cocktails.entrySet().stream().allMatch(entry -> entry.getValue() > 0);
        if (haveMadeAllCocktails) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredients.isEmpty()) {
            int sum = ingredients.stream().mapToInt(e -> e).sum();
            System.out.println("Ingredients left: " + sum);
        }
        cocktails.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .forEach(entry -> System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue()));
    }
}
