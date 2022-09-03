package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>, String> sizePrinter = list -> "Count = " + list.size();
        System.out.println(sizePrinter.apply(numbers));
        Function<List<Integer>, Integer> sum = list -> list.stream().mapToInt(value -> value).sum();
        Function<Integer, String> sumPrinter = integer -> "Sum = " + integer;
        System.out.println(sumPrinter.apply(sum.apply(numbers)));
    }
}
