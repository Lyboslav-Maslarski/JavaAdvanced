package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String currentURL = "";
        String input = scan.nextLine();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (!stack.isEmpty()) {
                    queue.addFirst(currentURL);
                    currentURL = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = scan.nextLine();
                    continue;
                }
            } else if (input.equals("forward")) {
                if (!queue.isEmpty()) {
                    stack.push(queue.peek());
                    currentURL = queue.poll();
                } else {
                    System.out.println("no next URLs");
                    input = scan.nextLine();
                    continue;
                }
            } else {
                queue.clear();
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
