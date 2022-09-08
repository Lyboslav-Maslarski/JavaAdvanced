package Generics.Exercise.GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Box<String>> strings = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            Box<String> s = new Box<>(scan.nextLine());
            strings.add(s);
        }
        int[] indexes = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int index1 = indexes[0];
        int index2 = indexes[1];
        Box.swap(strings, index1, index2);
        strings.forEach(System.out::println);
    }
}
