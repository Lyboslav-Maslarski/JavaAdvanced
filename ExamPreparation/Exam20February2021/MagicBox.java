package ExamPreparation.Exam20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> first = new ArrayDeque<>();
        Deque<Integer> second = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).forEach(first::offer);
        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).forEach(second::push);
        int items = 0;
        while (!first.isEmpty() && !second.isEmpty()) {
            int sum = first.peek() + second.peek();
            if (sum % 2 == 0) {
                items += sum;
                first.poll();
                second.pop();
            } else {
                first.offer(second.pop());
            }

        }
        if (first.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (second.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (items >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + items);
        } else {
            System.out.println("Poor prey... Value: " + items);
        }
    }
}
