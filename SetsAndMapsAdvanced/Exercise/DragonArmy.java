package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, int[]>> dragonTypes = new LinkedHashMap<>();
        int numberOfInputs = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < numberOfInputs; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String type = data[0];
            String name = data[1];
            int damage = data[2].equals("null") ? 45 : Integer.parseInt(data[2]);
            int health = data[3].equals("null") ? 250 : Integer.parseInt(data[3]);
            int armor = data[4].equals("null") ? 10 : Integer.parseInt(data[4]);
            int[] dragonInfo = new int[]{damage, health, armor};
            dragonTypes.putIfAbsent(type, new TreeMap<>());
            dragonTypes.get(type).put(name, dragonInfo);
        }
        dragonTypes.forEach((key, value) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", key, getAverage(value, 0), getAverage(value, 1), getAverage(value, 2));
            value.forEach((k, v) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", k, v[0], v[1], v[2]));
        });
    }

    private static double getAverage(Map<String, int[]> dragons, int i) {
        return dragons.values().stream().mapToInt(value -> value[i]).sum() * 1.0 / dragons.size();
    }
}
