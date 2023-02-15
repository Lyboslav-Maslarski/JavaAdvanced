package ExamPreparation.Exam25June2022;

import java.util.*;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Double> milkValues = new ArrayDeque<>();
        Deque<Double> cacaoValues = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(" ")).map(Double::parseDouble).forEach(milkValues::offer);
        Arrays.stream(scan.nextLine().split(" ")).map(Double::parseDouble).forEach(cacaoValues::push);

        Map<String, Integer> chocolates = new TreeMap<>();

        while (!milkValues.isEmpty() && !cacaoValues.isEmpty()) {
            double milk = milkValues.poll();
            double cacao = cacaoValues.pop();

            double cacaoPercentage = (cacao / (milk + cacao)) * 100;

            String chocolate = null;
            if (cacaoPercentage == 30) {
                chocolate = "Milk Chocolate";
            } else if (cacaoPercentage == 50) {
                chocolate = "Dark Chocolate";
            } else if (cacaoPercentage == 100) {
                chocolate = "Baking Chocolate";
            } else {
                milkValues.offer(milk + 10);
            }

            if (chocolate != null) {
                chocolates.putIfAbsent(chocolate, 0);
                chocolates.put(chocolate, chocolates.get(chocolate) + 1);
            }
        }

        if (chocolates.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        chocolates.forEach((key, value) -> System.out.println(" # " + key + " --> " + value + ""));
    }
}
