package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Double>> shopsWithProductsAndPrices = new TreeMap<>();
        String input = scan.nextLine();
        while (!input.equals("Revision")) {
            String[] data = input.split(", ");
            String shop = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);
            shopsWithProductsAndPrices.putIfAbsent(shop, new LinkedHashMap<>());
            shopsWithProductsAndPrices.get(shop).put(product, price);
            input = scan.nextLine();
        }
        shopsWithProductsAndPrices.forEach((k, v) -> {
            System.out.println(k + "->");
            v.forEach((product, price) -> System.out.printf("Product: %s, Price: %.1f%n", product, price));
        });
    }
}
