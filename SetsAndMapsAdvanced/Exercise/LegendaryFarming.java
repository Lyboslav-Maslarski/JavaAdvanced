package SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> legendaryItems = new LinkedHashMap<>();
        Map<String, Integer> junkItems = new TreeMap<>();
        legendaryItems.put("fragments", 0);
        legendaryItems.put("motes", 0);
        legendaryItems.put("shards", 0);
        String[] items = scan.nextLine().split(" ");
        boolean legendaryItemObtained = false;
        while (true) {
            for (int i = 0; i < items.length; i += 2) {
                int itemAmount = Integer.parseInt(items[i]);
                String item = items[i + 1].toLowerCase();
                if (item.equals("motes") || item.equals("shards") || item.equals("fragments")) {
                    legendaryItems.put(item, legendaryItems.get(item) + itemAmount);
                } else {
                    junkItems.putIfAbsent(item, 0);
                    junkItems.put(item, junkItems.get(item) + itemAmount);
                }
                if (legendaryItems.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    legendaryItems.put("motes", legendaryItems.get("motes") - 250);
                    legendaryItemObtained = true;
                    break;
                }
                if (legendaryItems.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    legendaryItems.put("shards", legendaryItems.get("shards") - 250);
                    legendaryItemObtained = true;
                    break;
                }
                if (legendaryItems.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    legendaryItems.put("fragments", legendaryItems.get("fragments") - 250);
                    legendaryItemObtained = true;
                    break;
                }
            }
            if (legendaryItemObtained) {
                break;
            }
            items = scan.nextLine().split(" ");
        }
        legendaryItems.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
        junkItems.forEach((item, amount) -> System.out.printf("%s: %d%n", item, amount));
    }
}
