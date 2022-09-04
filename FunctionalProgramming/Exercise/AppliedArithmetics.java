package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        UnaryOperator<List<Integer>> addFunc = list -> list.stream().map(e -> e + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtractFunc = list -> list.stream().map(e -> e - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiplyFunc = list -> list.stream().map(e -> e * 2).collect(Collectors.toList());
        Consumer<List<Integer>> printer = list -> System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        String command = scan.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = addFunc.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractFunc.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyFunc.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    break;
            }
            command = scan.nextLine();
        }
    }
}
