package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        long[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
        int[] turns = new int[numbers.length];
        Deque<Integer> indices = new ArrayDeque<>();
        indices.push(0);
        for (int i = 1; i < numbers.length; i++) {
            int maxTurns = 0;
            while (!indices.isEmpty() && numbers[indices.peek()] >= numbers[i]) {
                maxTurns = Math.max(maxTurns, turns[indices.pop()]);
            }
            if (!indices.isEmpty()) { //if empty, no smaller elems => won't be deleted => 0
                turns[i] = maxTurns + 1; //have to wait for the >= elems to be deleted (maxTurns), then delete
            }
            indices.push(i);
        }
        int maxTurns = 0;
        for (int turn : turns) {
            if (turn > maxTurns) {
                maxTurns = turn;
            }
        }
        System.out.println(maxTurns);

    }
}
