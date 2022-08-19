package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String currentURL = "";
        String input = scan.nextLine();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (!stack.isEmpty()) {
                    currentURL = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = scan.nextLine();
                    continue;
                }
            } else {
                if (!currentURL.equals("")) {
                    stack.push(currentURL);
                }
                currentURL = input;
            }
            System.out.println(currentURL);
            input = scan.nextLine();
        }
    }
}
