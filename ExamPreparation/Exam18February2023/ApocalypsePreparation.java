package ExamPreparation.Exam18February2023;

import java.util.*;
import java.util.stream.Collectors;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> textiles = new ArrayDeque<>();
        Deque<Integer> medicaments = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).forEach(textiles::offer);
        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).forEach(medicaments::push);

        Map<String, Integer> healingItems = new TreeMap<>();

        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            Integer textile = textiles.poll();
            Integer medicament = medicaments.pop();

            int sum = textile + medicament;
            String healingItem = null;

            if (sum == 30) {
                healingItem = "Patch";
            } else if (sum == 40) {
                healingItem = "Bandage";
            } else if (sum == 100) {
                healingItem = "MedKit";
            } else if (sum > 100) {
                healingItem = "MedKit";
                int nextMed = medicaments.pop();
                medicaments.push(nextMed + (sum - 100));
            } else {
                medicaments.push(medicament + 10);
            }

            if (healingItem != null) {
                healingItems.putIfAbsent(healingItem, 0);
                healingItems.put(healingItem, healingItems.get(healingItem) + 1);
            }
        }

        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        healingItems.entrySet().stream()
                .sorted((l, r) -> Integer.compare(r.getValue(), l.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

        if (!textiles.isEmpty()) {
            System.out.println("Textiles left: " + textiles.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (!medicaments.isEmpty()) {
            System.out.println("Medicaments left: " + medicaments.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
