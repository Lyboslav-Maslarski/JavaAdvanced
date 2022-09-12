package ExamPreparation.Exam16December2020;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int breadAmount = 0;
        int cakeAmount = 0;
        int fruitPieAmount = 0;
        int pastryAmount = 0;

        List<Integer> liquids = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> ingredients = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> liquidDeque = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientDeque = new ArrayDeque<>();

        liquids.forEach(liquidDeque::offer);
        ingredients.forEach(ingredientDeque::push);

        while (!liquidDeque.isEmpty() && !ingredientDeque.isEmpty()) {
            int liquid = liquidDeque.poll();
            int ingredient = ingredientDeque.pop();
            int sum = liquid + ingredient;
            if (sum == 25) {
                breadAmount++;
            } else if (sum == 50) {
                cakeAmount++;
            } else if (sum == 75) {
                pastryAmount++;
            } else if (sum == 100) {
                fruitPieAmount++;
            } else {
                ingredientDeque.push(ingredient + 3);
            }
        }
        if (breadAmount > 0 && cakeAmount > 0 && fruitPieAmount > 0 && pastryAmount > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        String remainingLiquids = liquidDeque.isEmpty() ? "none" : liquidDeque.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Liquids left: " + remainingLiquids);

        String remainingIngredients = ingredientDeque.isEmpty() ? "none" : ingredientDeque.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Ingredients left: " + String.join(", ", remainingIngredients));

        System.out.println("Bread: " + breadAmount);
        System.out.println("Cake: " + cakeAmount);
        System.out.println("Fruit Pie: " + fruitPieAmount);
        System.out.println("Pastry: " + pastryAmount);

    }
}
