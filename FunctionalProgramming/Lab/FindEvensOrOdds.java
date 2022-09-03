package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] range = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int start = range[0];
        int end = range[1];
        String predicate = scan.nextLine();
        System.out.println(IntStream.rangeClosed(start, end).boxed().filter(getPredicate(predicate)).map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static Predicate<Integer> getPredicate(String predicate) {
        if (predicate.equals("odd")) {
            return integer -> integer % 2 != 0;
        }
        return integer -> integer % 2 == 0;
    }
}

