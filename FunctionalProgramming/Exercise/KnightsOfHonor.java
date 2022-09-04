package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> people = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        Consumer<String> printer = person -> System.out.println("Sir " + person);
        people.forEach(printer);
    }
}
