package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Function<Integer[], Integer> minElement = integers -> Arrays.stream(integers).mapToInt(value -> value).min().getAsInt();
        System.out.println(minElement.apply(Arrays.stream(numbers).boxed().toArray(Integer[]::new)));
    }
}
