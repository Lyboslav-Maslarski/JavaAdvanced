package IteratorsAndComparators.Exercise.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ListyIterator listyIterator = null;
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Create":
                    String[] elements = Arrays.copyOfRange(command, 1, command.length);
                    listyIterator = new ListyIterator(elements);
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println("Invalid operation");
                    }
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "END":
                    return;
            }
            input = scan.nextLine();
        }
    }
}
