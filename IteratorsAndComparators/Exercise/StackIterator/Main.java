package IteratorsAndComparators.Exercise.StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Push":
                    for (int i = 1; i < command.length; i++) {
                        String s = command[i].replace(",", "");
                        Integer toAdd = Integer.valueOf(s);
                        stack.push(toAdd);
                    }
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }
            input = scan.nextLine();
        }
        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
