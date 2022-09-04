package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int maxLength = Integer.parseInt(scan.nextLine());
        Predicate<String> predicate = s -> s.length() <= maxLength;
        System.out.println(Arrays.stream(scan.nextLine().split("\\s+")).filter(predicate).collect(Collectors.joining(System.lineSeparator())));
    }
}
