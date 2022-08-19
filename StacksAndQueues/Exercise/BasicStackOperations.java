package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] command = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < command[0]; i++) {
            stack.push(scan.nextInt());
        }
        for (int i = 0; i < command[1]; i++) {
            stack.pop();
        }
        if (stack.contains(command[2])) {
            System.out.println("true");
        } else {
            System.out.println(stack.stream().min(Integer::compareTo).orElse(0));
        }
    }
}
