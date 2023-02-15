package ExamPreparation.Exam13April2022;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> steel = new ArrayDeque<>();
        Deque<Integer> carbon = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).forEach(steel::offer);
        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).forEach(carbon::push);

        Map<String, Integer> swords = new TreeMap<>();

        while (!steel.isEmpty() && !carbon.isEmpty()) {
            Integer poll = steel.poll();
            Integer pop = carbon.pop();

            int sum = poll + pop;

            String sword = null;
            if (sum == 70) {
                sword = "Gladius";
            } else if (sum == 80) {
                sword = "Shamshir";
            } else if (sum == 90) {
                sword = "Katana";
            } else if (sum == 110) {
                sword = "Sabre";
            } else {
                carbon.push(pop + 5);
            }

            if (sword != null) {
                swords.putIfAbsent(sword, 0);
                swords.put(sword, swords.get(sword) + 1);
            }
        }

        if (swords.isEmpty()) {
            System.out.println("You did not have enough resources to forge a sword.");
        } else {
            System.out.println("You have forged " + swords.values().stream().mapToInt(Integer::intValue).sum() + " swords.");
        }
        System.out.println("Steel left: " + (steel.isEmpty() ? "none" : steel.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        System.out.println("Carbon left: " + (carbon.isEmpty() ? "none" : carbon.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        if (!swords.isEmpty()) {
            swords.forEach((key, value) -> System.out.println(key + ": " + value));
        }
    }
}
