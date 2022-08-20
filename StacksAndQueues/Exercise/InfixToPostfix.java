package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();
        String[] expression = scan.nextLine().split(" ");
        for (int i = 0; i < expression.length; i++) {
            String currentChar = expression[i];
            if (!"-+*/()".contains(currentChar)) {
                outputQueue.offer(currentChar);
            } else if ("+-*/".contains(currentChar)) {
                if ("-+".contains(currentChar)) {
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        outputQueue.offer(operatorStack.pop());
                    }
                } else {
                    while (!operatorStack.isEmpty() && !"+-(".contains(operatorStack.peek())) {
                        outputQueue.offer(operatorStack.pop());
                    }
                }
                operatorStack.push(currentChar);
            } else if (currentChar.equals("(")) {
                operatorStack.push(currentChar);
            } else if (currentChar.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    outputQueue.offer(operatorStack.pop());
                }
                operatorStack.pop();
            }
        }
        while (!operatorStack.isEmpty()) {
            outputQueue.offer(operatorStack.pop());
        }
        outputQueue.forEach(character -> System.out.print(character + " "));
    }
}
