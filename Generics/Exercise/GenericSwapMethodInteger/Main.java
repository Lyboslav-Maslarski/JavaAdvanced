package Generics.Exercise.GenericSwapMethodInteger;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Box<Integer>> integers = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            Box<Integer> i = new Box<>(Integer.parseInt(scan.nextLine()));
            integers.add(i);
        }
        int[] indexes = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int index1 = indexes[0];
        int index2 = indexes[1];
        Box.swap(integers, index1, index2);
        integers.forEach(System.out::println);
    }
}
