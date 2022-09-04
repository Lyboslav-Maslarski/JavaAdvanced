package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int range = Integer.parseInt(scan.nextLine());
        List<Integer> numbersForDivision = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        IntPredicate predicate = num -> {
            for (Integer number : numbersForDivision) {
                if (num % number != 0) {
                    return false;
                }
            }
            return true;
        };
        System.out.println(IntStream.rangeClosed(1, range).filter(predicate).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
