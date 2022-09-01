package SetsAndMapsAdvanced.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Map<Character, Integer> charsCount = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            charsCount.putIfAbsent(currentChar, 0);
            charsCount.put(currentChar, charsCount.get(currentChar) + 1);
        }
        charsCount.forEach((key, value) -> System.out.println(key + ": " + value + " time/s"));
    }
}
