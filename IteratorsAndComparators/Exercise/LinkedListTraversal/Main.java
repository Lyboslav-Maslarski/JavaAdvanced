package IteratorsAndComparators.Exercise.LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedListTraversal<Integer> linkedListTraversal = new LinkedListTraversal<>();
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String[] commandParts = scan.nextLine().split("\\s+");
            String command = commandParts[0];
            int element = Integer.parseInt(commandParts[1]);
            if (command.equals("Add")) {
                linkedListTraversal.add(element);
            } else {
                linkedListTraversal.remove(element);
            }
        }
        System.out.println(linkedListTraversal.getSize());
        linkedListTraversal.forEach(integer -> System.out.print(integer + " "));
    }
}
