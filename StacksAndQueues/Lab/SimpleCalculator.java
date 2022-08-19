package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.addAll(Arrays.asList(input));
        while (arrayDeque.size() > 1) {
            int firstNum = Integer.parseInt(arrayDeque.pop());
            String operator = arrayDeque.pop();
            int secondNum = Integer.parseInt(arrayDeque.pop());
            int result;
            if (operator.equals("+")) {
                result = firstNum + secondNum;
            } else {
                result = firstNum - secondNum;
            }
            arrayDeque.push("" + result);
        }
        System.out.println(arrayDeque.peek());
    }
}
