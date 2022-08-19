package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();
        while (number > 0) {
            binary.push(number % 2);
            number /= 2;
        }
        if (binary.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(binary.toString().replaceAll("[\\[\\],\\s+]", ""));
        }
    }
}
