package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String command = scan.nextLine();
            switch (command) {
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(stack.stream().max(Integer::compareTo).orElseThrow());
                    break;
                default:
                    stack.push(Integer.parseInt(command.split("\\s+")[1]));
                    break;
            }
        }
    }
}
