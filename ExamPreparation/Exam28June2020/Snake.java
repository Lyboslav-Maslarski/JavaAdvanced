package ExamPreparation.Exam28June2020;

import java.util.Scanner;

public class Snake {
    static int food;
    static int row;
    static int col;
    static char[][] matrix;
    static boolean hasLeft;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            if (line.contains("S")) {
                row = i;
                col = line.indexOf("S");
            }
            matrix[i] = line.toCharArray();
        }

        while (food < 10) {
            String command = scan.nextLine();
            switch (command) {
                case "up":
                    moveSnake(-1, 0);
                    break;
                case "down":
                    moveSnake(1, 0);
                    break;
                case "left":
                    moveSnake(0, -1);
                    break;
                case "right":
                    moveSnake(0, 1);
                    break;
            }
            if (hasLeft) {
                break;
            }
        }
        if (hasLeft) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + food);
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

    private static void moveSnake(int rowMutator, int colMutator) {
        matrix[row][col] = '.';
        row += rowMutator;
        col += colMutator;
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
            hasLeft = true;
            return;
        }
        if (matrix[row][col] == '*') {
            food++;
        } else if (matrix[row][col] == 'B') {
            matrix[row][col] = '.';
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 'B') {
                        row = i;
                        col = j;
                        break;
                    }
                }
            }
        }
        matrix[row][col] = 'S';
    }
}
