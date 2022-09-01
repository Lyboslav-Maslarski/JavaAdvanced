package SetsAndMapsAdvanced.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<String> elements = new TreeSet<>();
        while (n-- > 0) {
            List<String> currentElements = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
            elements.addAll(currentElements);
        }
        System.out.println(String.join(" ", elements));
    }
}
