package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Double, Integer> numbersCount = new LinkedHashMap<>();
        double[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        for (double number : numbers) {
            numbersCount.putIfAbsent(number, 0);
            numbersCount.put(number, numbersCount.get(number) + 1);
        }
        numbersCount.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
