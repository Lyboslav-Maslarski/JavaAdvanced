package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else if (currentChar == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (currentChar == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (currentChar == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (currentChar == ')' || currentChar == '}' || currentChar == ']') {
                System.out.println("NO");
                return;
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
