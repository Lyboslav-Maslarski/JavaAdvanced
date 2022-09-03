package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        UnaryOperator<Double> addVAT = d -> d * 1.2;
        Consumer<Double> printer = n -> System.out.printf("%.2f%n", n);
        System.out.println("Prices with VAT:");
        Arrays.stream(scan.nextLine().split(", ")).map(Double::parseDouble).map(addVAT).forEach(printer);

    }
}
