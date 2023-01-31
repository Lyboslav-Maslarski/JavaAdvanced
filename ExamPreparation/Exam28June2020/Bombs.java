package ExamPreparation.Exam28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> effects = new ArrayDeque<>();
        Deque<Integer> casings = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(effects::offer);
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(casings::push);
        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Cherry Bombs", 0);
        bombs.put("Datura Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);
        while (!effects.isEmpty() && !casings.isEmpty()) {
            Integer peek = effects.peek();
            Integer pop = casings.pop();

            String bomb = "";

            int sum = peek + pop;
            if (sum == 40) {
                effects.poll();
                bomb = "Datura Bombs";
                bombs.put(bomb, bombs.get(bomb) + 1);
            } else if (sum == 60) {
                effects.poll();
                bomb = "Cherry Bombs";
                bombs.put(bomb, bombs.get(bomb) + 1);
            } else if (sum == 120) {
                effects.poll();
                bomb = "Smoke Decoy Bombs";
                bombs.put(bomb, bombs.get(bomb) + 1);
            } else {
                casings.push(pop - 5);
            }
            if (bombs.get("Cherry Bombs") >= 3 && bombs.get("Datura Bombs") >= 3 && bombs.get("Smoke Decoy Bombs") >= 3) {
                break;
            }
        }
        if (bombs.get("Cherry Bombs") >= 3 && bombs.get("Datura Bombs") >= 3 && bombs.get("Smoke Decoy Bombs") >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (effects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println("Bomb Effects: " + String.join(", ", effects.stream().map(String::valueOf).collect(Collectors.toList())));
        }
        if (casings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println("Bomb Casings: " + String.join(", ", casings.stream().map(String::valueOf).collect(Collectors.toList())));
        }
        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
