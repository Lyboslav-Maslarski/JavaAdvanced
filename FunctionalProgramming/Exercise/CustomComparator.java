package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Comparator<Integer> sortNumbers = (e1, e2) -> {
            if ((e1 % 2 == 0 && e2 % 2 == 0) || (e1 % 2 != 0 && e2 % 2 != 0)) {
                return e1 - e2;
            } else {
                return Math.abs(e1) % 2 - Math.abs(e2) % 2;
            }
        };

        Arrays.sort(numbers, sortNumbers);
        System.out.println(Arrays.stream(numbers).map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
