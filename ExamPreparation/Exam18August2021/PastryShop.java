package ExamPreparation.Exam18August2021;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> food = new LinkedHashMap<>();
        food.put("Biscuit", 0);
        food.put("Cake", 0);
        food.put("Pie", 0);
        food.put("Pastry", 0);

        Deque<Integer> liquids = new ArrayDeque<>();
        Deque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).forEach(liquids::offer);
        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).forEach(ingredients::push);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            Integer poll = liquids.poll();
            Integer pop = ingredients.pop();
            int sum = poll + pop;
            String result = "";
            boolean crafted = true;
            switch (sum) {
                case 25:
                    result = "Biscuit";
                    break;
                case 50:
                    result = "Cake";
                    break;
                case 75:
                    result = "Pastry";
                    break;
                case 100:
                    result = "Pie";
                    break;
                default:
                    ingredients.push(pop + 3);
                    crafted = false;
                    break;
            }
            if (crafted) {
                food.put(result, food.get(result) + 1);
            }
        }
        if (food.get("Biscuit") > 0 && food.get("Cake") > 0 && food.get("Pastry") > 0 && food.get("Pie") > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        System.out.println("Liquids left: " + (liquids.isEmpty() ? "none" : liquids.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        System.out.println("Ingredients left: " + (ingredients.isEmpty() ? "none" : ingredients.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        food.forEach((s, integer) -> System.out.println(s + ": " + integer));
    }
}
