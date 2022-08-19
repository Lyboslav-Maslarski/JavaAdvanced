package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String string = "";
        ArrayDeque<String> lastState = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] command = scan.nextLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    lastState.push(string);
                    string += (command[1]);
                    break;
                case "2":
                    lastState.push(string);
                    string = string.substring(0, string.length() - Integer.parseInt(command[1]));
                    break;
                case "3":
                    System.out.println(string.charAt(Integer.parseInt(command[1]) - 1));
                    break;
                case "4":
                    if (!lastState.isEmpty()) {
                        string = lastState.pop();
                    }
                    break;
            }
        }
    }
}
