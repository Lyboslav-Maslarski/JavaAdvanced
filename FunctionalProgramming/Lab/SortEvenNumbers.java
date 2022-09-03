package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(list.stream().sorted().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
