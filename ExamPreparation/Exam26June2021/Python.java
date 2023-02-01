package ExamPreparation.Exam26June2021;

import java.util.Scanner;

public class Python {
    static int row;
    static int col;
    static int length = 1;
    static int food;
    static boolean haveHitEnemy;
    static char[][] matrix;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        String[] commands = scan.nextLine().split(", ");

        matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine().replace(" ", "");
            if (line.contains("s")) {
                row = i;
                col = line.indexOf("s");
            }
            char[] chars = line.toCharArray();
            for (char c : chars) {
                if (c == 'f') {
                    food++;
                }
            }
            matrix[i] = chars;
        }
        for (String command : commands) {
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
            if (haveHitEnemy) {
                break;
            }
        }
        if (food==0) {
            System.out.println("You win! Final python length is " + length);
        } else if (haveHitEnemy) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.println("You lose! There is still " + food + " food to be eaten.");
        }
    }

    private static void moveSnake(int rowMutator, int colMutator) {
        matrix[row][col] = '*';
        int newRow = row + rowMutator;
        int newCol = col + colMutator;
        if (newRow < 0) {
            row = matrix.length - 1;
            col = newCol;
        } else if (newCol < 0) {
            row = newRow;
            col = matrix.length - 1;
        } else if (newRow == matrix.length) {
            row = 0;
            col = newCol;
        } else if (newCol == matrix.length) {
            row = newRow;
            col = 0;
        } else {
            row = newRow;
            col = newCol;
        }
        if (matrix[row][col] == 'f') {
            food--;
            length++;
        } else if (matrix[row][col] == 'e') {
            haveHitEnemy = true;
            return;
        }
        matrix[row][col] = 's';
    }
}
