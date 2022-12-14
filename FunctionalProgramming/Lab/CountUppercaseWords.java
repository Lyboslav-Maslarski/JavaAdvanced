package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Predicate<String> predicate = s -> Character.isUpperCase(s.charAt(0));
        List<String> list = Arrays.stream(scan.nextLine().split("\\s+")).filter(predicate).collect(Collectors.toList());
        System.out.println(list.size());
        Consumer<String> printer = System.out::println;
        list.forEach(printer);
    }
}
