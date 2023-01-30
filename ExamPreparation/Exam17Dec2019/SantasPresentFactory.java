package ExamPreparation.Exam17Dec2019;

import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> materials = new ArrayDeque<>();
        Deque<Integer> magicValues = new ArrayDeque<>();
        Map<String, Integer> toys = new TreeMap<>();

        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).forEach(materials::push);
        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).forEach(magicValues::offer);

        while (!materials.isEmpty() && !magicValues.isEmpty()) {

            if (magicValues.peek() != 0 && materials.peek() != 0) {
                Integer magicValue = magicValues.poll();
                Integer material = materials.pop();

                int multiplication = magicValue * material;
                String toy = "";
                if (multiplication < 0) {
                    int sum = magicValue + material;
                    materials.push(sum);
                } else if (multiplication == 150) {
                    toy = "Doll";
                    toys.putIfAbsent(toy, 0);
                    toys.put(toy, toys.get(toy) + 1);
                } else if (multiplication == 250) {
                    toy = "Wooden train";
                    toys.putIfAbsent(toy, 0);
                    toys.put(toy, toys.get(toy) + 1);
                } else if (multiplication == 300) {
                    toy = "Teddy bear";
                    toys.putIfAbsent(toy, 0);
                    toys.put(toy, toys.get(toy) + 1);
                } else if (multiplication == 400) {
                    toy = "Bicycle";
                    toys.putIfAbsent(toy, 0);
                    toys.put(toy, toys.get(toy) + 1);
                } else {
                    materials.push(material + 15);
                }
            } else {
                if (materials.peek() == 0) {
                    materials.pop();
                }

                if (magicValues.peek() == 0) {
                    magicValues.poll();
                }

            }
        }

        if ((toys.containsKey("Doll") && toys.containsKey("Wooden train")) || (toys.containsKey("Teddy bear") && toys.containsKey("Bicycle"))) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materials.isEmpty()) {
            System.out.println("Materials left: " + String.join(", ", materials.stream().map(String::valueOf).collect(Collectors.toList())));
        }

        if (!magicValues.isEmpty()) {
            System.out.println("Magic left: " + String.join(", ", magicValues.stream().map(String::valueOf).collect(Collectors.toList())));
        }

        toys.forEach((toy, count) -> System.out.println(toy + ": " + count));
    }
}
