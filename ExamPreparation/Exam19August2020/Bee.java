package ExamPreparation.Exam19August2020;

import java.util.Scanner;

public class Bee {
    private static int beeRow = 0;
    private static int beeCol = 0;
    private static int pollinatedFlowers = 0;
    private static boolean hasLeftField = false;
    private static final int NEEDED_FLOWERS = 5;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dimensions = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[dimensions][dimensions];

        for (int i = 0; i < dimensions; i++) {
            String row = scan.nextLine();
            if (row.contains("B")) {
                beeRow = i;
                beeCol = row.indexOf('B');
            }
            matrix[i] = row.toCharArray();
        }
        String command = scan.nextLine();
        while (!command.equals("End")) {
            if (command.equals("up")) {
                moveBee(matrix, -1, 0);
            } else if (command.equals("down")) {
                moveBee(matrix, 1, 0);
            } else if (command.equals("left")) {
                moveBee(matrix, 0, -1);
            } else if (command.equals("right")) {
                moveBee(matrix, 0, 1);
            }
            if (hasLeftField) {
                break;
            }
            command = scan.nextLine();
        }
        if (hasLeftField) {
            System.out.println("The bee got lost!");
        }
        if (pollinatedFlowers >= NEEDED_FLOWERS) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", NEEDED_FLOWERS - pollinatedFlowers);
        }
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

    private static void moveBee(char[][] matrix, int rowMutator, int colMutator) {
        matrix[beeRow][beeCol] = '.';
        int newBeeRow = beeRow + rowMutator;
        int newBeeCol = beeCol + colMutator;
        if (outsideField(matrix, newBeeRow, newBeeCol)) {
            hasLeftField = true;
            return;
        }
        beeRow = newBeeRow;
        beeCol = newBeeCol;
        if (matrix[newBeeRow][newBeeCol] == 'f') {
            pollinatedFlowers++;
        } else if (matrix[newBeeRow][newBeeCol] == 'O') {
            moveBee(matrix, rowMutator, colMutator);
            return;
        }

        matrix[beeRow][beeCol] = 'B';
    }

    private static boolean outsideField(char[][] matrix, int newBeeRow, int newBeeCol) {
        return 0 > newBeeRow || newBeeRow >= matrix.length || 0 > newBeeCol || newBeeCol >= matrix[newBeeRow].length;
    }
}
